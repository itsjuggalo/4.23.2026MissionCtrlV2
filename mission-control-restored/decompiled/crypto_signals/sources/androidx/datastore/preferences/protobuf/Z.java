package androidx.datastore.preferences.protobuf;

import com.google.protobuf.C0492v0;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Z implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4531b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Iterator f4533d;
    public final /* synthetic */ AbstractMap e;

    public /* synthetic */ Z(AbstractMap abstractMap, int i) {
        this.f4530a = i;
        this.e = abstractMap;
    }

    public final Iterator a() {
        switch (this.f4530a) {
            case 0:
                if (this.f4533d == null) {
                    this.f4533d = ((X) this.e).f4524b.entrySet().iterator();
                }
                break;
            default:
                if (this.f4533d == null) {
                    this.f4533d = ((C0492v0) this.e).f5810c.entrySet().iterator();
                }
                break;
        }
        return this.f4533d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f4530a) {
            case 0:
                int i = this.f4531b + 1;
                X x6 = (X) this.e;
                if (i >= x6.f4523a.size()) {
                    if (x6.f4524b.isEmpty() || !a().hasNext()) {
                    }
                }
                break;
            default:
                int i6 = this.f4531b + 1;
                C0492v0 c0492v0 = (C0492v0) this.e;
                if (i6 >= c0492v0.f5809b.size()) {
                    if (c0492v0.f5810c.isEmpty() || !a().hasNext()) {
                    }
                }
                break;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f4530a) {
            case 0:
                this.f4532c = true;
                int i = this.f4531b + 1;
                this.f4531b = i;
                X x6 = (X) this.e;
                if (i >= x6.f4523a.size()) {
                }
                break;
            default:
                this.f4532c = true;
                int i6 = this.f4531b + 1;
                this.f4531b = i6;
                C0492v0 c0492v0 = (C0492v0) this.e;
                if (i6 >= c0492v0.f5809b.size()) {
                }
                break;
        }
        return (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        AbstractMap abstractMap = this.e;
        switch (this.f4530a) {
            case 0:
                if (!this.f4532c) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.f4532c = false;
                int i = X.f4522f;
                X x6 = (X) abstractMap;
                x6.c();
                if (this.f4531b >= x6.f4523a.size()) {
                    a().remove();
                    return;
                }
                int i6 = this.f4531b;
                this.f4531b = i6 - 1;
                x6.i(i6);
                return;
            default:
                if (!this.f4532c) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.f4532c = false;
                int i7 = C0492v0.f5807k;
                C0492v0 c0492v0 = (C0492v0) abstractMap;
                c0492v0.c();
                if (this.f4531b >= c0492v0.f5809b.size()) {
                    a().remove();
                    return;
                }
                int i8 = this.f4531b;
                this.f4531b = i8 - 1;
                c0492v0.h(i8);
                return;
        }
    }
}
