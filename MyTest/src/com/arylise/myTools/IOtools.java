package com.arylise.myTools;

import java.io.*;

public class IOtools {
    public static int bufferByteSize = 1024 * 10;

    public enum reCode {
        ERROR_10("Copy: Successes!", 10),
        ERROR_11("Copy: Input Error", 11),
        ERROR_12("Copy: Output Error", 12),
        ERROR_13("Copy: Can't Find Input File", 13),
        ERROR_14("Copy: IOException", 14),
        ERROR_15("Copy: InputBuffer Close Exception", 15),
        ERROR_16("Copy: OutputBuffer Close Exception", 16),

        ERROR_20("Del: Successes!", 20),
        ERROR_21("Del: Input Error", 21),
        ERROR_22("Del: Can't Find Input File", 22),


        ERROR_30("Move: Successes!", 30),
        ERROR_31("Move: Input Error", 31),
        ERROR_32("Move: Output Error", 32);

        private final String error;
        private final int code;

        reCode(String error, int code) {
            this.error = error;
            this.code = code;
        }

        public void show() {
            System.out.println(this.error+" Code:"+this.code);
        }
    }

    private IOtools() {
    }

    public static reCode moveAll(String sourceFile, String targetFile) {
        return (sourceFile != null && targetFile != null) ?
                moveAll(new File(sourceFile), new File(targetFile)) :
                sourceFile == null ? reCode.ERROR_31 : reCode.ERROR_32;
    }

    public static reCode moveAll(File sourceFile, File targetFile) {
        sourceFile.renameTo(targetFile);
        return reCode.ERROR_30;
    }

    public static reCode deleteAll(String path) {
        return (path != null) ? deleteAll(new File(path)) : reCode.ERROR_21;
    }

    public static reCode deleteAll(File file) {
        if (file.isFile()) {
            file.delete();
            return reCode.ERROR_20;
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;
            if (files.length == 0) {
                file.delete();
                return reCode.ERROR_20;
            }
            for (File f : files) {
//                System.out.println(file.getName());
                if (f.isDirectory()) {
                    deleteAll(f);
                } else if (f.isFile()) {
                    f.delete();
                }
            }
            file.delete();
            return reCode.ERROR_20;
        }
        return reCode.ERROR_22;
    }


    // 复制文件夹下所有文件
    public static reCode copyAll(String sourceFile, String targetFile) {
        return (sourceFile != null && targetFile != null) ?
                copyAll(new File(sourceFile), new File(targetFile)) :
                sourceFile == null ? reCode.ERROR_11 : reCode.ERROR_12;
    }

    public static reCode copyAll(File sourceFile, File targetFile) {
        if (sourceFile.isFile()) {
            return copyFile(sourceFile, targetFile);
        } else if (sourceFile.isDirectory()) {
            return copyDirectory(sourceFile, targetFile);
        }
        return reCode.ERROR_13;
    }

    // 复制文件
    private static reCode copyFile(String sourceFile, String targetFile) {
        return (sourceFile != null && targetFile != null) ?
                copyFile(new File(sourceFile), new File(targetFile)) :
                sourceFile == null ? reCode.ERROR_11 : reCode.ERROR_12;
    }

    /**
     * @description  //TODO 复制文件copy在Files下有一个 public static Path copy(Path source, Path target, CopyOption... options)，挺...挺好用的
     *             反正我就是重复造轮子了，艹
     * @author Arylise
     * @date  2021/2/8 22:04
     */
    public static reCode copyFile(File sourceFile, File targetFile) {
        reCode ans = reCode.ERROR_10;
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
            byte[] b = new byte[bufferByteSize];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            ans = reCode.ERROR_14;
        } finally {
            try {
                if (inBuff != null)
                    inBuff.close();
            } catch (IOException e) {
                e.printStackTrace();
                ans = reCode.ERROR_15;
            }
            try {
                if (outBuff != null)
                    outBuff.close();
            } catch (IOException e) {
                e.printStackTrace();
                ans = reCode.ERROR_16;
            }
        }
        return ans;
    }

    // 复制文件夹
    public static reCode copyDirectory(String sourceDir, String targetDir) {
        return (sourceDir != null && targetDir != null) ?
                copyFile(new File(sourceDir), new File(targetDir)) :
                sourceDir == null ? reCode.ERROR_11 : reCode.ERROR_12;
    }

    public static reCode copyDirectory(File sourceDir, File targetDir) {
        // 新建目标目录
        if (!targetDir.exists())
            targetDir.mkdirs();
        File[] files = sourceDir.listFiles();
        assert files != null;
        if (files.length == 0) return reCode.ERROR_10;
        reCode ans = reCode.ERROR_10;
        for (File f : files) {
            if (f.isFile()) {
                ans = copyFile(
                        f,
                        new File(targetDir.getAbsolutePath() + File.separator + f.getName())
                );
            }
            if (f.isDirectory()) {
                ans = copyDirectory(
                        new File(sourceDir.getAbsolutePath() + "/" + f.getName()),
                        new File(targetDir.getAbsolutePath() + "/" + f.getName())
                );
            }
        }
        return ans;
    }
}
