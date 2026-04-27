package G1;

import H1.InterfaceC0586d;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import io.flutter.plugins.firebase.database.Constants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* JADX INFO: loaded from: classes.dex */
public class d implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0586d f2097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f2098c;

    public d(Context context, InterfaceC0586d interfaceC0586d, f fVar) {
        this.f2096a = context;
        this.f2097b = interfaceC0586d;
        this.f2098c = fVar;
    }

    @Override // G1.x
    public void a(z1.p pVar, int i8) {
        b(pVar, i8, false);
    }

    @Override // G1.x
    public void b(z1.p pVar, int i8, boolean z7) {
        ComponentName componentName = new ComponentName(this.f2096a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f2096a.getSystemService("jobscheduler");
        int iC = c(pVar);
        if (!z7 && d(jobScheduler, iC, i8)) {
            D1.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
            return;
        }
        long jI = this.f2097b.I(pVar);
        JobInfo.Builder builderC = this.f2098c.c(new JobInfo.Builder(iC, componentName), pVar.d(), jI, i8);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i8);
        persistableBundle.putString("backendName", pVar.b());
        persistableBundle.putInt(Constants.PRIORITY, K1.a.a(pVar.d()));
        if (pVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(pVar.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        D1.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", pVar, Integer.valueOf(iC), Long.valueOf(this.f2098c.g(pVar.d(), jI, i8)), Long.valueOf(jI), Integer.valueOf(i8));
        jobScheduler.schedule(builderC.build());
    }

    public int c(z1.p pVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f2096a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(pVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(K1.a.a(pVar.d())).array());
        if (pVar.c() != null) {
            adler32.update(pVar.c());
        }
        return (int) adler32.getValue();
    }

    public final boolean d(JobScheduler jobScheduler, int i8, int i9) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i10 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i8) {
                return i10 >= i9;
            }
        }
        return false;
    }
}
