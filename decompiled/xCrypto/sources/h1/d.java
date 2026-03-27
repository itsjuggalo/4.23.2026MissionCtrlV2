package h1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import e1.AbstractC1228a;
import i1.InterfaceC1297d;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.zip.Adler32;
import l1.AbstractC1589a;

/* JADX INFO: loaded from: classes.dex */
public class d implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1297d f12102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f12103c;

    public d(Context context, InterfaceC1297d interfaceC1297d, f fVar) {
        this.f12101a = context;
        this.f12102b = interfaceC1297d;
        this.f12103c = fVar;
    }

    @Override // h1.x
    public void a(a1.p pVar, int i4, boolean z4) {
        ComponentName componentName = new ComponentName(this.f12101a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f12101a.getSystemService("jobscheduler");
        int iC = c(pVar);
        if (!z4 && d(jobScheduler, iC, i4)) {
            AbstractC1228a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
            return;
        }
        long jT = this.f12102b.T(pVar);
        JobInfo.Builder builderC = this.f12103c.c(new JobInfo.Builder(iC, componentName), pVar.d(), jT, i4);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i4);
        persistableBundle.putString("backendName", pVar.b());
        persistableBundle.putInt("priority", AbstractC1589a.a(pVar.d()));
        if (pVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(pVar.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        AbstractC1228a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", pVar, Integer.valueOf(iC), Long.valueOf(this.f12103c.g(pVar.d(), jT, i4)), Long.valueOf(jT), Integer.valueOf(i4));
        jobScheduler.schedule(builderC.build());
    }

    @Override // h1.x
    public void b(a1.p pVar, int i4) {
        a(pVar, i4, false);
    }

    public int c(a1.p pVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f12101a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(pVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(AbstractC1589a.a(pVar.d())).array());
        if (pVar.c() != null) {
            adler32.update(pVar.c());
        }
        return (int) adler32.getValue();
    }

    public final boolean d(JobScheduler jobScheduler, int i4, int i5) {
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JobInfo next = it.next();
            int i6 = next.getExtras().getInt("attemptNumber");
            if (next.getId() == i4) {
                if (i6 >= i5) {
                    return true;
                }
            }
        }
        return false;
    }
}
