package org.lvJiang.song.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DemoEnum {

    A(1, "a"),
    B(2, "b");

    private int key;
    private String value;

    public static DemoEnum get(Integer key) {
        if (key == null) {
            return null;
        }
        for (DemoEnum demoEnum : DemoEnum.values()) {
            if (key == demoEnum.getKey()) {
                return demoEnum;
            }
        }
        return null;
    }
}
