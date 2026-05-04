package com.google.firebase.concurrent;

import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import d7.a;
import fa.b;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import o7.c;
import o7.d;
import o7.e0;
import o7.g;
import o7.w;
import p7.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f6112a = new w(new b() { // from class: p7.q
        @Override // fa.b
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newFixedThreadPool(4, ExecutorsRegistrar.k("Firebase Background", 10, ExecutorsRegistrar.i())));
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f6113b = new w(new b() { // from class: p7.r
        @Override // fa.b
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), ExecutorsRegistrar.k("Firebase Lite", 0, ExecutorsRegistrar.l())));
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w f6114c = new w(new b() { // from class: p7.s
        @Override // fa.b
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newCachedThreadPool(ExecutorsRegistrar.j("Firebase Blocking", 11)));
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w f6115d = new w(new b() { // from class: p7.t
        @Override // fa.b
        public final Object get() {
            return Executors.newSingleThreadScheduledExecutor(ExecutorsRegistrar.j("Firebase Scheduler", 0));
        }
    });

    public static /* synthetic */ ScheduledExecutorService a(d dVar) {
        return (ScheduledExecutorService) f6113b.get();
    }

    public static /* synthetic */ ScheduledExecutorService e(d dVar) {
        return (ScheduledExecutorService) f6114c.get();
    }

    public static /* synthetic */ ScheduledExecutorService g(d dVar) {
        return (ScheduledExecutorService) f6112a.get();
    }

    public static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i10 = Build.VERSION.SDK_INT;
        builderDetectNetwork.detectResourceMismatches();
        if (i10 >= 26) {
            builderDetectNetwork.detectUnbufferedIo();
        }
        return builderDetectNetwork.penaltyLog().build();
    }

    public static ThreadFactory j(String str, int i10) {
        return new p7.b(str, i10, null);
    }

    public static ThreadFactory k(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        return new p7.b(str, i10, threadPolicy);
    }

    public static StrictMode.ThreadPolicy l() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    public static ScheduledExecutorService m(ExecutorService executorService) {
        return new o(executorService, (ScheduledExecutorService) f6115d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(c.f(e0.a(a.class, ScheduledExecutorService.class), e0.a(a.class, ExecutorService.class), e0.a(a.class, Executor.class)).f(new g() { // from class: p7.u
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return ExecutorsRegistrar.g(dVar);
            }
        }).d(), c.f(e0.a(d7.b.class, ScheduledExecutorService.class), e0.a(d7.b.class, ExecutorService.class), e0.a(d7.b.class, Executor.class)).f(new g() { // from class: p7.v
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return ExecutorsRegistrar.e(dVar);
            }
        }).d(), c.f(e0.a(d7.c.class, ScheduledExecutorService.class), e0.a(d7.c.class, ExecutorService.class), e0.a(d7.c.class, Executor.class)).f(new g() { // from class: p7.w
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return ExecutorsRegistrar.a(dVar);
            }
        }).d(), c.e(e0.a(d7.d.class, Executor.class)).f(new g() { // from class: p7.x
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return a0.INSTANCE;
            }
        }).d());
    }
}
