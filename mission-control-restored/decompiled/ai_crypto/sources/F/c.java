package F;

import android.app.AlarmManager;
import android.app.PendingIntent;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    public static class a {
        public static AlarmManager.AlarmClockInfo a(long j7, PendingIntent pendingIntent) {
            return new AlarmManager.AlarmClockInfo(j7, pendingIntent);
        }

        public static void b(AlarmManager alarmManager, Object obj, PendingIntent pendingIntent) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) obj, pendingIntent);
        }
    }

    public static class b {
        public static void a(AlarmManager alarmManager, int i7, long j7, PendingIntent pendingIntent) {
            alarmManager.setAndAllowWhileIdle(i7, j7, pendingIntent);
        }

        public static void b(AlarmManager alarmManager, int i7, long j7, PendingIntent pendingIntent) {
            alarmManager.setExactAndAllowWhileIdle(i7, j7, pendingIntent);
        }
    }

    public static void a(AlarmManager alarmManager, long j7, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        a.b(alarmManager, a.a(j7, pendingIntent), pendingIntent2);
    }

    public static void b(AlarmManager alarmManager, int i7, long j7, PendingIntent pendingIntent) {
        b.a(alarmManager, i7, j7, pendingIntent);
    }

    public static void c(AlarmManager alarmManager, int i7, long j7, PendingIntent pendingIntent) {
        alarmManager.setExact(i7, j7, pendingIntent);
    }

    public static void d(AlarmManager alarmManager, int i7, long j7, PendingIntent pendingIntent) {
        b.b(alarmManager, i7, j7, pendingIntent);
    }
}
