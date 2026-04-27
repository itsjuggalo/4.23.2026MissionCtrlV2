package k4;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class m extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JobInfo f7913d;
    public final JobScheduler e;

    public m(Context context, ComponentName componentName, int i) {
        super(componentName);
        b(i);
        this.f7913d = new JobInfo.Builder(i, componentName).setOverrideDeadline(0L).build();
        this.e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
    }

    @Override // k4.n
    public final void a(Intent intent) {
        this.e.enqueue(this.f7913d, io.flutter.plugin.editing.h.e(intent));
    }
}
