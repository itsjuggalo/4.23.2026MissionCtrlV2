package com.google.firebase.crashlytics;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CustomKeysAndValues {
    final Map<String, String> keysAndValues;

    public static class Builder {
        private Map<String, String> keysAndValues = new HashMap();

        public CustomKeysAndValues build() {
            return new CustomKeysAndValues(this);
        }

        public Builder putBoolean(String str, boolean z4) {
            this.keysAndValues.put(str, Boolean.toString(z4));
            return this;
        }

        public Builder putDouble(String str, double d4) {
            this.keysAndValues.put(str, Double.toString(d4));
            return this;
        }

        public Builder putFloat(String str, float f4) {
            this.keysAndValues.put(str, Float.toString(f4));
            return this;
        }

        public Builder putInt(String str, int i4) {
            this.keysAndValues.put(str, Integer.toString(i4));
            return this;
        }

        public Builder putLong(String str, long j4) {
            this.keysAndValues.put(str, Long.toString(j4));
            return this;
        }

        public Builder putString(String str, String str2) {
            this.keysAndValues.put(str, str2);
            return this;
        }
    }

    public CustomKeysAndValues(Builder builder) {
        this.keysAndValues = builder.keysAndValues;
    }
}
