package v3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f10621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f10622b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m f10624d;
    public final /* synthetic */ int e;

    public j(m mVar, int i) {
        this.e = i;
        this.f10624d = mVar;
        this.f10621a = mVar.f10640f.f10630d;
        this.f10623c = mVar.e;
    }

    public final Object a() {
        return b();
    }

    public final l b() {
        l lVar = this.f10621a;
        m mVar = this.f10624d;
        if (lVar == mVar.f10640f) {
            throw new NoSuchElementException();
        }
        if (mVar.e != this.f10623c) {
            throw new ConcurrentModificationException();
        }
        this.f10621a = lVar.f10630d;
        this.f10622b = lVar;
        return lVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f10621a != this.f10624d.f10640f;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.e) {
            case 1:
                return b().f10631f;
            default:
                return a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        l lVar = this.f10622b;
        if (lVar == null) {
            throw new IllegalStateException();
        }
        m mVar = this.f10624d;
        mVar.d(lVar, true);
        this.f10622b = null;
        this.f10623c = mVar.e;
    }
}
