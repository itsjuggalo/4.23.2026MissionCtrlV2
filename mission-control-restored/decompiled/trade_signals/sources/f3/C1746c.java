package f3;

import java.util.concurrent.ScheduledExecutorService;
import o3.InterfaceC2461d;

/* JADX INFO: renamed from: f3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1746c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f17403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1747d f17404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC1747d f17405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2461d f17406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f17407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f17408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f17409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f17410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f17411i;

    public C1746c(InterfaceC2461d interfaceC2461d, InterfaceC1747d interfaceC1747d, InterfaceC1747d interfaceC1747d2, ScheduledExecutorService scheduledExecutorService, boolean z7, String str, String str2, String str3, String str4) {
        this.f17406d = interfaceC2461d;
        this.f17404b = interfaceC1747d;
        this.f17405c = interfaceC1747d2;
        this.f17403a = scheduledExecutorService;
        this.f17407e = z7;
        this.f17408f = str;
        this.f17409g = str2;
        this.f17410h = str3;
        this.f17411i = str4;
    }

    public InterfaceC1747d a() {
        return this.f17405c;
    }

    public String b() {
        return this.f17410h;
    }

    public InterfaceC1747d c() {
        return this.f17404b;
    }

    public String d() {
        return this.f17408f;
    }

    public ScheduledExecutorService e() {
        return this.f17403a;
    }

    public InterfaceC2461d f() {
        return this.f17406d;
    }

    public String g() {
        return this.f17411i;
    }

    public String h() {
        return this.f17409g;
    }

    public boolean i() {
        return this.f17407e;
    }
}
