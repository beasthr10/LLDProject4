package com.beasthr10.lld4.utility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pair<K,V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
