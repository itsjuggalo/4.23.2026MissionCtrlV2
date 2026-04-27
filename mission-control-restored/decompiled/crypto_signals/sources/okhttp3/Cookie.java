package okhttp3;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class Cookie {

    public static final class Builder {
    }

    static {
        Pattern.compile("(\\d{2,4})[^\\d]*");
        Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        Pattern.compile("(\\d{1,2})[^\\d]*");
        Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        ((Cookie) obj).getClass();
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return ((String) null) + '=' + ((String) null) + "; domain=" + ((String) null) + "; path=" + ((String) null);
    }
}
