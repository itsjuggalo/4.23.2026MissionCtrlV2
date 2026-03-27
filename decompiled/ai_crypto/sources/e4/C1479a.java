package e4;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.internal.AbstractC1173j;
import com.google.android.gms.common.api.internal.C1172i;
import com.google.android.gms.common.api.internal.InterfaceC1174k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: e4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1479a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1479a f13609c = new C1479a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f13610a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13611b = new Object();

    /* JADX INFO: renamed from: e4.a$a, reason: collision with other inner class name */
    public static class C0234a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f13612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f13613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f13614c;

        public C0234a(Activity activity, Runnable runnable, Object obj) {
            this.f13612a = activity;
            this.f13613b = runnable;
            this.f13614c = obj;
        }

        public Activity a() {
            return this.f13612a;
        }

        public Object b() {
            return this.f13614c;
        }

        public Runnable c() {
            return this.f13613b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0234a)) {
                return false;
            }
            C0234a c0234a = (C0234a) obj;
            return c0234a.f13614c.equals(this.f13614c) && c0234a.f13613b == this.f13613b && c0234a.f13612a == this.f13612a;
        }

        public int hashCode() {
            return this.f13614c.hashCode();
        }
    }

    /* JADX INFO: renamed from: e4.a$b */
    public static class b extends AbstractC1173j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f13615a;

        public b(InterfaceC1174k interfaceC1174k) {
            super(interfaceC1174k);
            this.f13615a = new ArrayList();
            this.mLifecycleFragment.b("StorageOnStopCallback", this);
        }

        public static b b(Activity activity) {
            InterfaceC1174k fragment = AbstractC1173j.getFragment(new C1172i(activity));
            b bVar = (b) fragment.d("StorageOnStopCallback", b.class);
            return bVar == null ? new b(fragment) : bVar;
        }

        public void a(C0234a c0234a) {
            synchronized (this.f13615a) {
                this.f13615a.add(c0234a);
            }
        }

        public void c(C0234a c0234a) {
            synchronized (this.f13615a) {
                this.f13615a.remove(c0234a);
            }
        }

        @Override // com.google.android.gms.common.api.internal.AbstractC1173j
        public void onStop() {
            ArrayList<C0234a> arrayList;
            synchronized (this.f13615a) {
                arrayList = new ArrayList(this.f13615a);
                this.f13615a.clear();
            }
            for (C0234a c0234a : arrayList) {
                if (c0234a != null) {
                    Log.d("StorageOnStopCallback", "removing subscription from activity.");
                    c0234a.c().run();
                    C1479a.a().b(c0234a.b());
                }
            }
        }
    }

    public static C1479a a() {
        return f13609c;
    }

    public void b(Object obj) {
        synchronized (this.f13611b) {
            try {
                C0234a c0234a = (C0234a) this.f13610a.get(obj);
                if (c0234a != null) {
                    b.b(c0234a.a()).c(c0234a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(Activity activity, Object obj, Runnable runnable) {
        synchronized (this.f13611b) {
            C0234a c0234a = new C0234a(activity, runnable, obj);
            b.b(activity).a(c0234a);
            this.f13610a.put(obj, c0234a);
        }
    }
}
