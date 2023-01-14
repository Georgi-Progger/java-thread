package main.java.FooProd;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class AppRunClass {
    public static void main(String[] args) {

        Runnable r1 = () -> System.out.print("first");
        Runnable r2 = () -> System.out.print("second");
        Runnable r3 = () -> System.out.print("third");
        Foo foo = new Foo();
        CompletableFuture.runAsync(() ->{
            try {
                foo.first(r1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture.runAsync(() -> {
            try {
                foo.third(r3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture.runAsync(() -> {
            try {
                foo.second(r2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
