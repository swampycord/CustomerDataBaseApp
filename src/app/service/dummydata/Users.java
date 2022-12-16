package app.service.dummydata;

import app.service.entities.UserEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Users {
    private final static List<UserEntity> list = Arrays.asList(//
            new UserEntity("bdoorson", "qwerty1234"),//
            new UserEntity("wdoorson", "qwerty1234"),//
            new UserEntity("rdoorson", "qwerty1234"),//
            new UserEntity("amaanster", "qwerty1234"),//
            new UserEntity("pmaanster", "qwerty1234")//
    );

    public static List<UserEntity> getHardCodedList() {
        return list;
    }

    public static List<UserEntity> getCustomList() {
        return new ArrayList<UserEntity>();
    }
}
