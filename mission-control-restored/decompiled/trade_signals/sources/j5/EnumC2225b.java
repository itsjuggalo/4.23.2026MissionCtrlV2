package j5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: j5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public enum EnumC2225b implements Callable, V4.e {
    INSTANCE;

    public static Callable b() {
        return INSTANCE;
    }

    @Override // V4.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List apply(Object obj) {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public List call() {
        return new ArrayList();
    }
}
