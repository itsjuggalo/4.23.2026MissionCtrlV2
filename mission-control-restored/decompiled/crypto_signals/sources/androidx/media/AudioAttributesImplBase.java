package androidx.media;

import a3.d;
import java.util.Arrays;
import s3.B0;
import s3.I0;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4707a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4708b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4709c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4710d = -1;

    public final boolean equals(Object obj) {
        int i;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f4708b == audioAttributesImplBase.f4708b) {
            int i6 = this.f4709c;
            int i7 = audioAttributesImplBase.f4709c;
            int i8 = audioAttributesImplBase.f4710d;
            if (i8 == -1) {
                int i9 = audioAttributesImplBase.f4707a;
                int i10 = AudioAttributesCompat.f4703b;
                if ((i7 & 1) != 1) {
                    if ((i7 & 4) != 4) {
                        switch (i9) {
                            case 2:
                                i = 0;
                                break;
                            case 3:
                                i = 8;
                                break;
                            case 4:
                                i = 4;
                                break;
                            case 5:
                            case 7:
                            case 8:
                            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                                i = 5;
                                break;
                            case 6:
                                i = 2;
                                break;
                            case 11:
                                i = 10;
                                break;
                            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            default:
                                i = 3;
                                break;
                            case 13:
                                i = 1;
                                break;
                        }
                    } else {
                        i = 6;
                    }
                } else {
                    i = 7;
                }
            } else {
                i = i8;
            }
            if (i == 6) {
                i7 |= 4;
            } else if (i == 7) {
                i7 |= 1;
            }
            if (i6 == (i7 & 273) && this.f4707a == audioAttributesImplBase.f4707a && this.f4710d == i8) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4708b), Integer.valueOf(this.f4709c), Integer.valueOf(this.f4707a), Integer.valueOf(this.f4710d)});
    }

    public final String toString() {
        String strF;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f4710d != -1) {
            sb.append(" stream=");
            sb.append(this.f4710d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int i = this.f4707a;
        int i6 = AudioAttributesCompat.f4703b;
        switch (i) {
            case 0:
                strF = "USAGE_UNKNOWN";
                break;
            case 1:
                strF = "USAGE_MEDIA";
                break;
            case 2:
                strF = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                strF = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case 4:
                strF = "USAGE_ALARM";
                break;
            case 5:
                strF = "USAGE_NOTIFICATION";
                break;
            case 6:
                strF = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case 7:
                strF = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                strF = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                strF = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                strF = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                strF = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                strF = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case 13:
                strF = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                strF = "USAGE_GAME";
                break;
            case 15:
            default:
                strF = d.f(i, "unknown usage ");
                break;
            case 16:
                strF = "USAGE_ASSISTANT";
                break;
        }
        sb.append(strF);
        sb.append(" content=");
        sb.append(this.f4708b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f4709c).toUpperCase());
        return sb.toString();
    }
}
