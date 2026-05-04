package com.google.android.gms.common.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f5788a = new k0();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        Object a(com.google.android.gms.common.api.k kVar);
    }

    public static Task a(com.google.android.gms.common.api.h hVar, a aVar) {
        n0 n0Var = f5788a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        hVar.addStatusListener(new l0(hVar, taskCompletionSource, aVar, n0Var));
        return taskCompletionSource.getTask();
    }

    public static Task b(com.google.android.gms.common.api.h hVar) {
        return a(hVar, new m0());
    }
}
