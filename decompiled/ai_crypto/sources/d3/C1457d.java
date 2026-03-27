package d3;

import N3.a;
import S2.a;
import android.os.Bundle;
import e3.C1478g;
import f3.C1603c;
import f3.C1604d;
import f3.C1605e;
import f3.C1606f;
import f3.InterfaceC1601a;
import g3.C1637c;
import g3.InterfaceC1635a;
import g3.InterfaceC1636b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: d3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1457d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N3.a f13335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile InterfaceC1601a f13336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile InterfaceC1636b f13337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f13338d;

    public C1457d(N3.a aVar) {
        this(aVar, new C1637c(), new C1606f());
    }

    public static a.InterfaceC0080a j(S2.a aVar, C1458e c1458e) {
        a.InterfaceC0080a interfaceC0080aA = aVar.a("clx", c1458e);
        if (interfaceC0080aA == null) {
            C1478g.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            interfaceC0080aA = aVar.a("crash", c1458e);
            if (interfaceC0080aA != null) {
                C1478g.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return interfaceC0080aA;
    }

    public InterfaceC1601a d() {
        return new InterfaceC1601a() { // from class: d3.b
            @Override // f3.InterfaceC1601a
            public final void a(String str, Bundle bundle) {
                this.f13333a.g(str, bundle);
            }
        };
    }

    public InterfaceC1636b e() {
        return new InterfaceC1636b() { // from class: d3.a
            @Override // g3.InterfaceC1636b
            public final void a(InterfaceC1635a interfaceC1635a) {
                this.f13332a.h(interfaceC1635a);
            }
        };
    }

    public final void f() {
        this.f13335a.a(new a.InterfaceC0058a() { // from class: d3.c
            @Override // N3.a.InterfaceC0058a
            public final void a(N3.b bVar) {
                this.f13334a.i(bVar);
            }
        });
    }

    public final /* synthetic */ void g(String str, Bundle bundle) {
        this.f13336b.a(str, bundle);
    }

    public final /* synthetic */ void h(InterfaceC1635a interfaceC1635a) {
        synchronized (this) {
            try {
                if (this.f13337c instanceof C1637c) {
                    this.f13338d.add(interfaceC1635a);
                }
                this.f13337c.a(interfaceC1635a);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void i(N3.b bVar) {
        C1478g.f().b("AnalyticsConnector now available.");
        S2.a aVar = (S2.a) bVar.get();
        C1605e c1605e = new C1605e(aVar);
        C1458e c1458e = new C1458e();
        if (j(aVar, c1458e) == null) {
            C1478g.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
            return;
        }
        C1478g.f().b("Registered Firebase Analytics listener.");
        C1604d c1604d = new C1604d();
        C1603c c1603c = new C1603c(c1605e, 500, TimeUnit.MILLISECONDS);
        synchronized (this) {
            try {
                Iterator it = this.f13338d.iterator();
                while (it.hasNext()) {
                    c1604d.a((InterfaceC1635a) it.next());
                }
                c1458e.d(c1604d);
                c1458e.e(c1603c);
                this.f13337c = c1604d;
                this.f13336b = c1603c;
            } finally {
            }
        }
    }

    public C1457d(N3.a aVar, InterfaceC1636b interfaceC1636b, InterfaceC1601a interfaceC1601a) {
        this.f13335a = aVar;
        this.f13337c = interfaceC1636b;
        this.f13338d = new ArrayList();
        this.f13336b = interfaceC1601a;
        f();
    }
}
