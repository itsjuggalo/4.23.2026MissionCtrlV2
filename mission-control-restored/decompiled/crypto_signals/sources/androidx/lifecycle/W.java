package androidx.lifecycle;

import d0.C0520b;

/* JADX INFO: loaded from: classes.dex */
public interface W {
    default T a(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    default T f(Class cls, C0520b c0520b) {
        return a(cls);
    }
}
