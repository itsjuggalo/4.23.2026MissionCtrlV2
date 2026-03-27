package com.google.protobuf;

import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public abstract class s0 {

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1240i f12781a;

        public a(AbstractC1240i abstractC1240i) {
            this.f12781a = abstractC1240i;
        }

        @Override // com.google.protobuf.s0.b
        public byte a(int i7) {
            return this.f12781a.g(i7);
        }

        @Override // com.google.protobuf.s0.b
        public int size() {
            return this.f12781a.size();
        }
    }

    public interface b {
        byte a(int i7);

        int size();
    }

    public static String a(AbstractC1240i abstractC1240i) {
        return b(new a(abstractC1240i));
    }

    public static String b(b bVar) {
        StringBuilder sb = new StringBuilder(bVar.size());
        for (int i7 = 0; i7 < bVar.size(); i7++) {
            byte bA = bVar.a(i7);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                        sb.append("\\t");
                        break;
                    case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                        } else {
                            sb.append((char) bA);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static String c(String str) {
        return a(AbstractC1240i.p(str));
    }
}
