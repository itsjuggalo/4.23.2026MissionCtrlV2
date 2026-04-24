package O;

import android.os.FileObserver;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class q0 extends FileObserver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f2276b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f2277c = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f2278a;

    public q0(String str) {
        super(str, 128);
        this.f2278a = new CopyOnWriteArrayList();
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        Iterator it = this.f2278a.iterator();
        while (it.hasNext()) {
            ((R4.l) it.next()).invoke(str);
        }
    }
}
