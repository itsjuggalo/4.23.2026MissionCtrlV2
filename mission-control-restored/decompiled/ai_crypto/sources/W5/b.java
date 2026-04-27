package W5;

import F5.AbstractC0554l;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends AbstractC0554l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5446d;

    public b(char c7, char c8, int i7) {
        this.f5443a = i7;
        this.f5444b = c8;
        boolean z7 = false;
        if (i7 <= 0 ? r.g(c7, c8) >= 0 : r.g(c7, c8) <= 0) {
            z7 = true;
        }
        this.f5445c = z7;
        this.f5446d = z7 ? c7 : c8;
    }

    @Override // F5.AbstractC0554l
    public char c() {
        int i7 = this.f5446d;
        if (i7 != this.f5444b) {
            this.f5446d = this.f5443a + i7;
        } else {
            if (!this.f5445c) {
                throw new NoSuchElementException();
            }
            this.f5445c = false;
        }
        return (char) i7;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f5445c;
    }
}
