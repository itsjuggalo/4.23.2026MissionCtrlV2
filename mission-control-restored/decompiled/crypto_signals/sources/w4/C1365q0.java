package w4;

import java.net.SocketAddress;
import java.util.List;
import u4.C1236s;

/* JADX INFO: renamed from: w4.q0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1365q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f11347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11349c;

    public SocketAddress a() {
        if (c()) {
            return (SocketAddress) ((C1236s) this.f11347a.get(this.f11348b)).f10484a.get(this.f11349c);
        }
        throw new IllegalStateException("Index is past the end of the address group list");
    }

    public boolean b() {
        if (c()) {
            C1236s c1236s = (C1236s) this.f11347a.get(this.f11348b);
            int i = this.f11349c + 1;
            this.f11349c = i;
            if (i >= c1236s.f10484a.size()) {
                int i6 = this.f11348b + 1;
                this.f11348b = i6;
                this.f11349c = 0;
                if (i6 < this.f11347a.size()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean c() {
        return this.f11348b < this.f11347a.size();
    }

    public void d() {
        this.f11348b = 0;
        this.f11349c = 0;
    }

    public boolean e(SocketAddress socketAddress) {
        for (int i = 0; i < this.f11347a.size(); i++) {
            int iIndexOf = ((C1236s) this.f11347a.get(i)).f10484a.indexOf(socketAddress);
            if (iIndexOf != -1) {
                this.f11348b = i;
                this.f11349c = iIndexOf;
                return true;
            }
        }
        return false;
    }
}
