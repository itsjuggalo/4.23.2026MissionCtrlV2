package V1;

import java.util.AbstractMap;
import java.util.Objects;
import s3.D;

/* JADX INFO: loaded from: classes.dex */
public final class j extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f3210c;

    public j(k kVar) {
        this.f3210c = kVar;
    }

    @Override // java.util.List
    public final Object get(int i) {
        k kVar = this.f3210c;
        D.i(i, kVar.f3212f);
        int i6 = i * 2;
        Object[] objArr = kVar.e;
        Object obj = objArr[i6];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i6 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // V1.a
    public final boolean k() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3210c.f3212f;
    }
}
