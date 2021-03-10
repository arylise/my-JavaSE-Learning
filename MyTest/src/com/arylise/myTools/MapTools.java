package com.arylise.myTools;

import java.util.*;

public class MapTools {

    private MapTools() {
    }

    public static class getSameValue {
        private getSameValue() {
        }

        /**
         * @Description //TODO 找出集合中重复value项
         * @Date 2021/2/8 22:30
         * @Author Arylise
         */
        public static <K, V> Map<V, List<K>> getSameValueListMap(Map<K, V> map) {
            Collection<V> values = map.values();
            List<V> list = distinct(findRepeat(values));
            Map<V, List<K>> result = new HashMap<>();
            for (V value : list) {
                List<K> keyList = new ArrayList<>();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    if (entry.getValue().equals(value)) {
                        keyList.add(entry.getKey());
                    }
                }
                result.put(value, keyList);
            }
            List<K> notNeed = new ArrayList<>();
            for (Map.Entry<V, List<K>> entry : result.entrySet()) {
                List<K> value = entry.getValue();
                for (int i = 0; i < value.size(); i++) {
                    if (i != value.size() - 1) {
                        notNeed.add(value.get(i));
                    }
                }
            }
            return result;
        }

        /**
         * @Description //TODO 将collection集合去重
         * @Date 2021/2/8 22:31
         * @Author Arylise
         */
        public static <T> List<T> distinct(Collection<T> data) {
            if (data == null) {
                return new ArrayList<>();
            }
            Set<T> set = new HashSet<>(data);
            return new ArrayList<>(set);
        }

        /**
         * @Description //TODO 找出collection中的重复项
         * @Date 2021/2/8 22:31
         * @Author Arylise
         */
        public static <T> List<T> findRepeat(Collection<T> data) {
            if (data instanceof Set) {
                return new ArrayList<>();
            }
            HashSet<T> set = new HashSet<T>();
            List<T> repeatEles = new ArrayList<T>();
            for (T t : data) {
                if (set.contains(t)) {
                    repeatEles.add(t);
                } else {
                    set.add(t);
                }
            }
            return repeatEles;
        }
    }
}
