package j$.time.zone;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArrayList f17334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap f17335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Set f17336c;

    protected abstract f c(String str);

    protected abstract Set d();

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        f17334a = copyOnWriteArrayList;
        f17335b = new ConcurrentHashMap(512, 0.75f, 2);
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new h(arrayList));
        copyOnWriteArrayList.addAll(arrayList);
    }

    public static Set a() {
        return f17336c;
    }

    public static f b(String str, boolean z7) {
        Objects.requireNonNull(str, "zoneId");
        ConcurrentHashMap concurrentHashMap = f17335b;
        j jVar = (j) concurrentHashMap.get(str);
        if (jVar != null) {
            return jVar.c(str);
        }
        if (concurrentHashMap.isEmpty()) {
            throw new g("No time-zone data files registered");
        }
        throw new g("Unknown time-zone ID: ".concat(str));
    }

    public static void e(j jVar) {
        Objects.requireNonNull(jVar, "provider");
        synchronized (j.class) {
            try {
                for (String str : jVar.d()) {
                    Objects.requireNonNull(str, "zoneId");
                    if (((j) f17335b.putIfAbsent(str, jVar)) != null) {
                        throw new g("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + jVar);
                    }
                }
                f17336c = Collections.unmodifiableSet(new HashSet(f17335b.keySet()));
            } catch (Throwable th) {
                throw th;
            }
        }
        f17334a.add(jVar);
    }
}
