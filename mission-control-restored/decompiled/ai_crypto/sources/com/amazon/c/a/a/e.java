package com.amazon.c.a.a;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10154a = String.format("A valid instance of %s is required to have at least one non-blank ID, either developerId or certificateId, and at least one non-blank name, either developerName or commonName.", e.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10155b = String.format("A valid instance of %s is required to have a certificate ID.", e.class.getSimpleName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f10159f;

    public static String a() {
        return f10154a;
    }

    public static String b() {
        return f10155b;
    }

    public boolean c() {
        return (StringUtils.isBlank(e()) || StringUtils.isBlank(f())) ? false : true;
    }

    public boolean d() {
        return !StringUtils.isBlank(e());
    }

    public String e() {
        return StringUtils.isBlank(this.f10158e) ? this.f10156c : this.f10158e;
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
        return new EqualsBuilder().append(this.f10158e, eVar.f10158e).append(this.f10159f, eVar.f10159f).append(this.f10156c, eVar.f10156c).append(this.f10157d, eVar.f10157d).isEquals();
    }

    public String f() {
        return StringUtils.isBlank(this.f10159f) ? this.f10157d : this.f10159f;
    }

    public String g() {
        return this.f10156c;
    }

    public String h() {
        return this.f10157d;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(this.f10158e).append(this.f10159f).append(this.f10156c).append(this.f10157d).toHashCode();
    }

    public String i() {
        return this.f10158e;
    }

    public String j() {
        return this.f10159f;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public e a(String str) {
        this.f10156c = str;
        return this;
    }

    public void b(String str) {
        this.f10156c = str;
    }

    public e c(String str) {
        this.f10157d = str;
        return this;
    }

    public void d(String str) {
        this.f10157d = str;
    }

    public e g(String str) {
        this.f10159f = str;
        return this;
    }

    public void h(String str) {
        this.f10159f = str;
    }

    public e e(String str) {
        this.f10158e = str;
        return this;
    }

    public void f(String str) {
        this.f10158e = str;
    }
}
