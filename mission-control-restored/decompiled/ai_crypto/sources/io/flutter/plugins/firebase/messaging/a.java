package io.flutter.plugins.firebase.messaging;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import h5.AbstractC1723I;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends Service {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f16824g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap f16825h = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f16826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f16827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0258a f16828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16829d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f16830e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f16831f = new ArrayList();

    /* JADX INFO: renamed from: io.flutter.plugins.firebase.messaging.a$a, reason: collision with other inner class name */
    public final class C0258a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f16832a = Executors.newSingleThreadExecutor();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f16833b = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: io.flutter.plugins.firebase.messaging.a$a$a, reason: collision with other inner class name */
        public class RunnableC0259a implements Runnable {

            /* JADX INFO: renamed from: io.flutter.plugins.firebase.messaging.a$a$a$a, reason: collision with other inner class name */
            public class RunnableC0260a implements Runnable {
                public RunnableC0260a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.i();
                }
            }

            public RunnableC0259a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    f fVarA = a.this.a();
                    if (fVarA == null) {
                        C0258a.this.f16833b.post(new RunnableC0260a());
                        return;
                    } else {
                        a.this.g(fVarA.getIntent());
                        fVarA.a();
                    }
                }
            }
        }

        public C0258a() {
        }

        public void b() {
            a.this.i();
        }

        public void c() {
            this.f16832a.execute(new RunnableC0259a());
        }
    }

    public interface b {
        IBinder a();

        f b();
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Context f16837d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PowerManager.WakeLock f16838e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final PowerManager.WakeLock f16839f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f16840g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f16841h;

        public c(Context context, ComponentName componentName) {
            super(componentName);
            this.f16837d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f16838e = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f16839f = wakeLockNewWakeLock2;
            wakeLockNewWakeLock2.setReferenceCounted(false);
        }

        @Override // io.flutter.plugins.firebase.messaging.a.i
        public void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f16854a);
            if (this.f16837d.startService(intent2) != null) {
                synchronized (this) {
                    try {
                        if (!this.f16840g) {
                            this.f16840g = true;
                            if (!this.f16841h) {
                                this.f16838e.acquire(60000L);
                            }
                        }
                    } finally {
                    }
                }
            }
        }

        @Override // io.flutter.plugins.firebase.messaging.a.i
        public void c() {
            synchronized (this) {
                try {
                    if (this.f16841h) {
                        if (this.f16840g) {
                            this.f16838e.acquire(60000L);
                        }
                        this.f16841h = false;
                        this.f16839f.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.flutter.plugins.firebase.messaging.a.i
        public void d() {
            synchronized (this) {
                try {
                    if (!this.f16841h) {
                        this.f16841h = true;
                        this.f16839f.acquire(600000L);
                        this.f16838e.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.flutter.plugins.firebase.messaging.a.i
        public void e() {
            synchronized (this) {
                this.f16840g = false;
            }
        }
    }

    public final class d implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f16842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f16843b;

        public d(Intent intent, int i7) {
            this.f16842a = intent;
            this.f16843b = i7;
        }

        @Override // io.flutter.plugins.firebase.messaging.a.f
        public void a() {
            a.this.stopSelf(this.f16843b);
        }

        @Override // io.flutter.plugins.firebase.messaging.a.f
        public Intent getIntent() {
            return this.f16842a;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ComponentName f16845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f16846b;

        public e(ComponentName componentName, boolean z7) {
            this.f16845a = componentName;
            this.f16846b = z7;
        }
    }

    public interface f {
        void a();

        Intent getIntent();
    }

    public static final class g extends JobServiceEngine implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f16847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f16848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JobParameters f16849c;

        /* JADX INFO: renamed from: io.flutter.plugins.firebase.messaging.a$g$a, reason: collision with other inner class name */
        public final class C0261a implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final JobWorkItem f16850a;

            public C0261a(JobWorkItem jobWorkItem) {
                this.f16850a = jobWorkItem;
            }

            @Override // io.flutter.plugins.firebase.messaging.a.f
            public void a() {
                synchronized (g.this.f16848b) {
                    JobParameters jobParameters = g.this.f16849c;
                    if (jobParameters != null) {
                        try {
                            jobParameters.completeWork(this.f16850a);
                        } catch (IllegalArgumentException e7) {
                            Log.e("JobServiceEngineImpl", "IllegalArgumentException: Failed to run mParams.completeWork(mJobWork)!", e7);
                        } catch (SecurityException e8) {
                            Log.e("JobServiceEngineImpl", "SecurityException: Failed to run mParams.completeWork(mJobWork)!", e8);
                        }
                    }
                }
            }

            @Override // io.flutter.plugins.firebase.messaging.a.f
            public Intent getIntent() {
                return this.f16850a.getIntent();
            }
        }

        public g(a aVar) {
            super(aVar);
            this.f16848b = new Object();
            this.f16847a = aVar;
        }

        @Override // io.flutter.plugins.firebase.messaging.a.b
        public IBinder a() {
            return getBinder();
        }

        @Override // io.flutter.plugins.firebase.messaging.a.b
        public f b() {
            synchronized (this.f16848b) {
                JobParameters jobParameters = this.f16849c;
                if (jobParameters == null) {
                    return null;
                }
                try {
                    JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                    if (jobWorkItemDequeueWork == null) {
                        return null;
                    }
                    jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f16847a.getClassLoader());
                    return new C0261a(jobWorkItemDequeueWork);
                } catch (SecurityException e7) {
                    Log.e("JobServiceEngineImpl", "Failed to run mParams.dequeueWork()!", e7);
                    return null;
                }
            }
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f16849c = jobParameters;
            this.f16847a.e(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean zB = this.f16847a.b();
            synchronized (this.f16848b) {
                this.f16849c = null;
            }
            return zB;
        }
    }

    public static final class h extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JobInfo f16852d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final JobScheduler f16853e;

        public h(Context context, ComponentName componentName, int i7) {
            super(componentName);
            b(i7);
            this.f16852d = new JobInfo.Builder(i7, this.f16854a).setOverrideDeadline(0L).build();
            this.f16853e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // io.flutter.plugins.firebase.messaging.a.i
        public void a(Intent intent) {
            this.f16853e.enqueue(this.f16852d, AbstractC1723I.a(intent));
        }
    }

    public static abstract class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f16854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f16855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16856c;

        public i(ComponentName componentName) {
            this.f16854a = componentName;
        }

        public abstract void a(Intent intent);

        public void b(int i7) {
            if (!this.f16855b) {
                this.f16855b = true;
                this.f16856c = i7;
            } else {
                if (this.f16856c == i7) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i7 + " is different than previous " + this.f16856c);
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public static void c(Context context, ComponentName componentName, int i7, Intent intent, boolean z7) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (f16824g) {
            i iVarF = f(context, componentName, true, i7, z7);
            iVarF.b(i7);
            try {
                iVarF.a(intent);
            } catch (IllegalStateException e7) {
                if (!z7) {
                    throw e7;
                }
                f(context, componentName, true, i7, false).a(intent);
            }
        }
    }

    public static void d(Context context, Class cls, int i7, Intent intent, boolean z7) {
        c(context, new ComponentName(context, (Class<?>) cls), i7, intent, z7);
    }

    public static i f(Context context, ComponentName componentName, boolean z7, int i7, boolean z8) {
        i cVar;
        e eVar = new e(componentName, z8);
        HashMap map = f16825h;
        i iVar = (i) map.get(eVar);
        if (iVar == null) {
            if (Build.VERSION.SDK_INT < 26 || z8) {
                cVar = new c(context, componentName);
            } else {
                if (!z7) {
                    throw new IllegalArgumentException("Can't be here without a job id");
                }
                cVar = new h(context, componentName, i7);
            }
            iVar = cVar;
            map.put(eVar, iVar);
        }
        return iVar;
    }

    public f a() {
        f fVarB;
        b bVar = this.f16826a;
        if (bVar != null && (fVarB = bVar.b()) != null) {
            return fVarB;
        }
        synchronized (this.f16831f) {
            try {
                if (this.f16831f.size() > 0) {
                    return (f) this.f16831f.remove(0);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b() {
        C0258a c0258a = this.f16828c;
        if (c0258a != null) {
            c0258a.b();
        }
        this.f16829d = true;
        return h();
    }

    public void e(boolean z7) {
        if (this.f16828c == null) {
            this.f16828c = new C0258a();
            i iVar = this.f16827b;
            if (iVar != null && z7) {
                iVar.d();
            }
            this.f16828c.c();
        }
    }

    public abstract void g(Intent intent);

    public boolean h() {
        return true;
    }

    public void i() {
        ArrayList arrayList = this.f16831f;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f16828c = null;
                    ArrayList arrayList2 = this.f16831f;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        e(false);
                    } else if (!this.f16830e) {
                        this.f16827b.c();
                    }
                } finally {
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f16826a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f16826a = new g(this);
            this.f16827b = null;
        }
        this.f16827b = f(this, new ComponentName(this, getClass()), false, 0, true);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b();
        synchronized (this.f16831f) {
            this.f16830e = true;
            this.f16827b.c();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i7, int i8) {
        this.f16827b.e();
        synchronized (this.f16831f) {
            ArrayList arrayList = this.f16831f;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i8));
            e(true);
        }
        return 3;
    }
}
