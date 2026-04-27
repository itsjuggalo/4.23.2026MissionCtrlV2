package com.google.firebase.concurrent;

import N3.b;
import U2.a;
import U2.c;
import U2.d;
import android.os.Build;
import android.os.StrictMode;
import b3.C0982E;
import b3.C0986c;
import b3.InterfaceC0987d;
import b3.InterfaceC0990g;
import b3.w;
import c3.EnumC1131D;
import c3.ThreadFactoryC1133b;
import c3.o;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f12090a = new w(new b() { // from class: c3.r
        @Override // N3.b
        public final Object get() {
            return ExecutorsRegistrar.p();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f12091b = new w(new b() { // from class: c3.s
        @Override // N3.b
        public final Object get() {
            return ExecutorsRegistrar.q();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w f12092c = new w(new b() { // from class: c3.t
        @Override // N3.b
        public final Object get() {
            return ExecutorsRegistrar.r();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w f12093d = new w(new b() { // from class: c3.u
        @Override // N3.b
        public final Object get() {
            return ExecutorsRegistrar.s();
        }
    });

    public static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i7 = Build.VERSION.SDK_INT;
        builderDetectNetwork.detectResourceMismatches();
        if (i7 >= 26) {
            builderDetectNetwork.detectUnbufferedIo();
        }
        return builderDetectNetwork.penaltyLog().build();
    }

    public static ThreadFactory j(String str, int i7) {
        return new ThreadFactoryC1133b(str, i7, null);
    }

    public static ThreadFactory k(String str, int i7, StrictMode.ThreadPolicy threadPolicy) {
        return new ThreadFactoryC1133b(str, i7, threadPolicy);
    }

    public static /* synthetic */ ScheduledExecutorService l(InterfaceC0987d interfaceC0987d) {
        return (ScheduledExecutorService) f12090a.get();
    }

    public static /* synthetic */ ScheduledExecutorService m(InterfaceC0987d interfaceC0987d) {
        return (ScheduledExecutorService) f12092c.get();
    }

    public static /* synthetic */ ScheduledExecutorService n(InterfaceC0987d interfaceC0987d) {
        return (ScheduledExecutorService) f12091b.get();
    }

    public static /* synthetic */ Executor o(InterfaceC0987d interfaceC0987d) {
        return EnumC1131D.INSTANCE;
    }

    public static /* synthetic */ ScheduledExecutorService p() {
        return u(Executors.newFixedThreadPool(4, k("Firebase Background", 10, i())));
    }

    public static /* synthetic */ ScheduledExecutorService q() {
        return u(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), k("Firebase Lite", 0, t())));
    }

    public static /* synthetic */ ScheduledExecutorService r() {
        return u(Executors.newCachedThreadPool(j("Firebase Blocking", 11)));
    }

    public static /* synthetic */ ScheduledExecutorService s() {
        return Executors.newSingleThreadScheduledExecutor(j("Firebase Scheduler", 0));
    }

    public static StrictMode.ThreadPolicy t() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    public static ScheduledExecutorService u(ExecutorService executorService) {
        return new o(executorService, (ScheduledExecutorService) f12093d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(C0986c.d(C0982E.a(a.class, ScheduledExecutorService.class), C0982E.a(a.class, ExecutorService.class), C0982E.a(a.class, Executor.class)).f(new InterfaceC0990g() { // from class: c3.v
            @Override // b3.InterfaceC0990g
            public final Object a(InterfaceC0987d interfaceC0987d) {
                return ExecutorsRegistrar.l(interfaceC0987d);
            }
        }).d(), C0986c.d(C0982E.a(U2.b.class, ScheduledExecutorService.class), C0982E.a(U2.b.class, ExecutorService.class), C0982E.a(U2.b.class, Executor.class)).f(new InterfaceC0990g() { // from class: c3.w
            @Override // b3.InterfaceC0990g
            public final Object a(InterfaceC0987d interfaceC0987d) {
                return ExecutorsRegistrar.m(interfaceC0987d);
            }
        }).d(), C0986c.d(C0982E.a(c.class, ScheduledExecutorService.class), C0982E.a(c.class, ExecutorService.class), C0982E.a(c.class, Executor.class)).f(new InterfaceC0990g() { // from class: c3.x
            @Override // b3.InterfaceC0990g
            public final Object a(InterfaceC0987d interfaceC0987d) {
                return ExecutorsRegistrar.n(interfaceC0987d);
            }
        }).d(), C0986c.c(C0982E.a(d.class, Executor.class)).f(new InterfaceC0990g() { // from class: c3.y
            @Override // b3.InterfaceC0990g
            public final Object a(InterfaceC0987d interfaceC0987d) {
                return ExecutorsRegistrar.o(interfaceC0987d);
            }
        }).d());
    }
}
