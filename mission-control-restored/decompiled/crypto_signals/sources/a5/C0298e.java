package a5;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: a5.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0298e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4114b = AtomicIntegerFieldUpdater.newUpdater(C0298e.class, "notCompletedCount$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F[] f4115a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    public C0298e(F[] fArr) {
        this.f4115a = fArr;
        this.notCompletedCount$volatile = fArr.length;
    }
}
