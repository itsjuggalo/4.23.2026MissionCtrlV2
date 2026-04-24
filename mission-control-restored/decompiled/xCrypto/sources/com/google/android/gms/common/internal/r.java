package com.google.android.gms.common.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final P f9959a = new M();

    public interface a {
        Object a(com.google.android.gms.common.api.k kVar);
    }

    public static Task a(com.google.android.gms.common.api.h hVar, a aVar) {
        P p4 = f9959a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        hVar.addStatusListener(new N(hVar, taskCompletionSource, aVar, p4));
        return taskCompletionSource.getTask();
    }

    public static Task b(com.google.android.gms.common.api.h hVar) {
        return a(hVar, new O());
    }
}
