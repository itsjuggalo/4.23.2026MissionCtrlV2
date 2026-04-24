package l1;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import q1.C2627j;
import w.C2882a;

/* JADX INFO: renamed from: l1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2315d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f20526a = new AtomicReference();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2882a f20527b = new C2882a();

    public List a(Class cls, Class cls2, Class cls3) {
        List list;
        C2627j c2627j = (C2627j) this.f20526a.getAndSet(null);
        if (c2627j == null) {
            c2627j = new C2627j(cls, cls2, cls3);
        } else {
            c2627j.a(cls, cls2, cls3);
        }
        synchronized (this.f20527b) {
            list = (List) this.f20527b.get(c2627j);
        }
        this.f20526a.set(c2627j);
        return list;
    }

    public void b(Class cls, Class cls2, Class cls3, List list) {
        synchronized (this.f20527b) {
            this.f20527b.put(new C2627j(cls, cls2, cls3), list);
        }
    }
}
