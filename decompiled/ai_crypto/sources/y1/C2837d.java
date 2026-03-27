package y1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;
import v1.AbstractC2763a;
import z1.InterfaceC2859d;

/* JADX INFO: renamed from: y1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2837d implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f25465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2859d f25466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2839f f25467c;

    public C2837d(Context context, InterfaceC2859d interfaceC2859d, AbstractC2839f abstractC2839f) {
        this.f25465a = context;
        this.f25466b = interfaceC2859d;
        this.f25467c = abstractC2839f;
    }

    @Override // y1.x
    public void a(r1.p pVar, int i7, boolean z7) {
        ComponentName componentName = new ComponentName(this.f25465a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f25465a.getSystemService("jobscheduler");
        int iC = c(pVar);
        if (!z7 && d(jobScheduler, iC, i7)) {
            AbstractC2763a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
            return;
        }
        long jW0 = this.f25466b.w0(pVar);
        JobInfo.Builder builderC = this.f25467c.c(new JobInfo.Builder(iC, componentName), pVar.d(), jW0, i7);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i7);
        persistableBundle.putString("backendName", pVar.b());
        persistableBundle.putInt("priority", C1.a.a(pVar.d()));
        if (pVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(pVar.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        AbstractC2763a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", pVar, Integer.valueOf(iC), Long.valueOf(this.f25467c.g(pVar.d(), jW0, i7)), Long.valueOf(jW0), Integer.valueOf(i7));
        jobScheduler.schedule(builderC.build());
    }

    @Override // y1.x
    public void b(r1.p pVar, int i7) {
        a(pVar, i7, false);
    }

    public int c(r1.p pVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f25465a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(pVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(C1.a.a(pVar.d())).array());
        if (pVar.c() != null) {
            adler32.update(pVar.c());
        }
        return (int) adler32.getValue();
    }

    public final boolean d(JobScheduler jobScheduler, int i7, int i8) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i9 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i7) {
                return i9 >= i8;
            }
        }
        return false;
    }
}
