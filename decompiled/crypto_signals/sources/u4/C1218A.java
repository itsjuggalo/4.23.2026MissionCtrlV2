package u4;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Logger;

/* JADX INFO: renamed from: u4.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1218A {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f10331d = Logger.getLogger(C1218A.class.getName());
    public static final C1218A e = new C1218A();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentSkipListMap f10332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f10333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f10334c;

    public C1218A() {
        new ConcurrentSkipListMap();
        this.f10332a = new ConcurrentSkipListMap();
        this.f10333b = new ConcurrentHashMap();
        this.f10334c = new ConcurrentHashMap();
        new ConcurrentHashMap();
    }
}
