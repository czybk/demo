package com.fly.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

/**
 * User: Administrator
 * Date: 2018/12/20
 * Time: 17:47
 */
public class Atomic {
    static AtomicInteger ai = new AtomicInteger(1);
    static int[] value = new int[] { 1, 2 };
    static AtomicIntegerArray bi = new AtomicIntegerArray(value);
    public static AtomicReference<User> atomicUserRef = new AtomicReference<User>();
    static class User {
        private String name;
        private int old;
        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }
        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
        User user = new User("conan", 15);
        atomicUserRef.set(user);
        User updateUser = new User("Shinichi", 17);
        atomicUserRef.compareAndSet(user, updateUser);
        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getOld());
    }

}
