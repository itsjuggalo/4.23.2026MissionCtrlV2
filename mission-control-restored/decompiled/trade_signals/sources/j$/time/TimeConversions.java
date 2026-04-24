package j$.time;

/* JADX INFO: loaded from: classes3.dex */
public class TimeConversions {
    public static Duration convert(java.time.Duration duration) {
        if (duration == null) {
            return null;
        }
        return Duration.R(duration.getSeconds(), duration.getNano());
    }

    public static java.time.Duration convert(Duration duration) {
        if (duration == null) {
            return null;
        }
        return java.time.Duration.ofSeconds(duration.H(), duration.A());
    }
}
