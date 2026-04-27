package com.google.firebase.concurrent;

import J2.a;
import J2.c;
import J2.d;
import M2.C0700c;
import M2.E;
import M2.InterfaceC0701d;
import M2.g;
import M2.w;
import N2.B;
import N2.ThreadFactoryC0705b;
import N2.o;
import S3.b;
import android.os.Build;
import android.os.StrictMode;
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
    public static final w f15553a = new w(new b() { // from class: N2.r
        @Override // S3.b
        public final Object get() {
            return ExecutorsRegistrar.p();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f15554b = new w(new b() { // from class: N2.s
        @Override // S3.b
        public final Object get() {
            return ExecutorsRegistrar.q();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w f15555c = new w(new b() { // from class: N2.t
        @Override // S3.b
        public final Object get() {
            return ExecutorsRegistrar.r();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w f15556d = new w(new b() { // from class: N2.u
        @Override // S3.b
        public final Object get() {
            return ExecutorsRegistrar.s();
        }
    });

    public static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i8 = Build.VERSION.SDK_INT;
        builderDetectNetwork.detectResourceMismatches();
        if (i8 >= 26) {
            builderDetectNetwork.detectUnbufferedIo();
        }
        return builderDetectNetwork.penaltyLog().build();
    }

    public static ThreadFactory j(String str, int i8) {
        return new ThreadFactoryC0705b(str, i8, null);
    }

    public static ThreadFactory k(String str, int i8, StrictMode.ThreadPolicy threadPolicy) {
        return new ThreadFactoryC0705b(str, i8, threadPolicy);
    }

    public static /* synthetic */ ScheduledExecutorService l(InterfaceC0701d interfaceC0701d) {
        return (ScheduledExecutorService) f15553a.get();
    }

    public static /* synthetic */ ScheduledExecutorService m(InterfaceC0701d interfaceC0701d) {
        return (ScheduledExecutorService) f15555c.get();
    }

    public static /* synthetic */ ScheduledExecutorService n(InterfaceC0701d interfaceC0701d) {
        return (ScheduledExecutorService) f15554b.get();
    }

    public static /* synthetic */ Executor o(InterfaceC0701d interfaceC0701d) {
        return B.INSTANCE;
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
        return new o(executorService, (ScheduledExecutorService) f15556d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(C0700c.d(E.a(a.class, ScheduledExecutorService.class), E.a(a.class, ExecutorService.class), E.a(a.class, Executor.class)).f(new g() { // from class: N2.v
            @Override // M2.g
            public final Object create(InterfaceC0701d interfaceC0701d) {
                return ExecutorsRegistrar.l(interfaceC0701d);
            }
        }).d(), C0700c.d(E.a(J2.b.class, ScheduledExecutorService.class), E.a(J2.b.class, ExecutorService.class), E.a(J2.b.class, Executor.class)).f(new g() { // from class: N2.w
            @Override // M2.g
            public final Object create(InterfaceC0701d interfaceC0701d) {
                return ExecutorsRegistrar.m(interfaceC0701d);
            }
        }).d(), C0700c.d(E.a(c.class, ScheduledExecutorService.class), E.a(c.class, ExecutorService.class), E.a(c.class, Executor.class)).f(new g() { // from class: N2.x
            @Override // M2.g
            public final Object create(InterfaceC0701d interfaceC0701d) {
                return ExecutorsRegistrar.n(interfaceC0701d);
            }
        }).d(), C0700c.c(E.a(d.class, Executor.class)).f(new g() { // from class: N2.y
            @Override // M2.g
            public final Object create(InterfaceC0701d interfaceC0701d) {
                return ExecutorsRegistrar.o(interfaceC0701d);
            }
        }).d());
    }
}
