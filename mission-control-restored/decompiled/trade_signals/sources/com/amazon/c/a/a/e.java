package com.amazon.c.a.a;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14265a = String.format("A valid instance of %s is required to have at least one non-blank ID, either developerId or certificateId, and at least one non-blank name, either developerName or commonName.", e.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14266b = String.format("A valid instance of %s is required to have a certificate ID.", e.class.getSimpleName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14270f;

    public static String b() {
        return f14266b;
    }

    public e a(String str) {
        this.f14267c = str;
        return this;
    }

    public e c(String str) {
        this.f14268d = str;
        return this;
    }

    public void d(String str) {
        this.f14268d = str;
    }

    public e e(String str) {
        this.f14269e = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return new EqualsBuilder().append(this.f14269e, eVar.f14269e).append(this.f14270f, eVar.f14270f).append(this.f14267c, eVar.f14267c).append(this.f14268d, eVar.f14268d).isEquals();
    }

    public String f() {
        return StringUtils.isBlank(this.f14270f) ? this.f14268d : this.f14270f;
    }

    public e g(String str) {
        this.f14270f = str;
        return this;
    }

    public String h() {
        return this.f14268d;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(this.f14269e).append(this.f14270f).append(this.f14267c).append(this.f14268d).toHashCode();
    }

    public String i() {
        return this.f14269e;
    }

    public String j() {
        return this.f14270f;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public static String a() {
        return f14265a;
    }

    public void b(String str) {
        this.f14267c = str;
    }

    public boolean c() {
        return (StringUtils.isBlank(e()) || StringUtils.isBlank(f())) ? false : true;
    }

    public boolean d() {
        return !StringUtils.isBlank(e());
    }

    public String e() {
        return StringUtils.isBlank(this.f14269e) ? this.f14267c : this.f14269e;
    }

    public void f(String str) {
        this.f14269e = str;
    }

    public String g() {
        return this.f14267c;
    }

    public void h(String str) {
        this.f14270f = str;
    }
}
