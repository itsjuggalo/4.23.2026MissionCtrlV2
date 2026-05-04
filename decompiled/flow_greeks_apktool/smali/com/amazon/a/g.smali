.class public final Lcom/amazon/a/g;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcom/amazon/a/a/k/d;


# static fields
.field protected static final a:Ljava/lang/String; = "ActivityName"

.field protected static final b:Ljava/lang/String; = "EventName"

.field protected static final c:Ljava/lang/String; = "Timestamp"

.field private static final d:Lcom/amazon/a/a/o/c;

.field private static e:Lcom/amazon/a/g;


# instance fields
.field private final f:Z

.field private g:Lcom/amazon/a/a/a/a;
    .annotation runtime Lcom/amazon/a/a/k/a;
    .end annotation
.end field

.field private h:Lcom/amazon/a/a/l/b;
    .annotation runtime Lcom/amazon/a/a/k/a;
    .end annotation
.end field

.field private i:Lcom/amazon/a/a/c/f;
    .annotation runtime Lcom/amazon/a/a/k/a;
    .end annotation
.end field

.field private j:Lcom/amazon/a/a/n/b;
    .annotation runtime Lcom/amazon/a/a/k/a;
    .end annotation
.end field

.field private k:Lcom/amazon/a/a/i/e;
    .annotation runtime Lcom/amazon/a/a/k/a;
    .end annotation
.end field

.field private l:Lcom/amazon/a/a/m/c;
    .annotation runtime Lcom/amazon/a/a/k/a;
    .end annotation
.end field

.field private m:Landroid/app/Application;
    .annotation runtime Lcom/amazon/a/a/k/a;
    .end annotation
.end field

.field private n:Lcom/amazon/a/a/o/b/b;
    .annotation runtime Lcom/amazon/a/a/k/a;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/amazon/a/a/o/c;

    .line 2
    .line 3
    const-string v1, "Kiwi"

    .line 4
    .line 5
    invoke-direct {v0, v1}, Lcom/amazon/a/a/o/c;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    sput-object v0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    .line 9
    .line 10
    return-void
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method private constructor <init>(Landroid/app/Application;Z)V
    .locals 5

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    .line 5
    .line 6
    .line 7
    move-result-wide v0

    .line 8
    iput-boolean p2, p0, Lcom/amazon/a/g;->f:Z

    .line 9
    .line 10
    sget-boolean v2, Lcom/amazon/a/a/o/c;->a:Z

    .line 11
    .line 12
    if-eqz v2, :cond_0

    .line 13
    .line 14
    sget-object v2, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    .line 15
    .line 16
    new-instance v3, Ljava/lang/StringBuilder;

    .line 17
    .line 18
    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 19
    .line 20
    .line 21
    const-string v4, "Starting initialization process for application: "

    .line 22
    .line 23
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 24
    .line 25
    .line 26
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    .line 27
    .line 28
    .line 29
    move-result-object v4

    .line 30
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 31
    .line 32
    .line 33
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 34
    .line 35
    .line 36
    move-result-object v3

    .line 37
    invoke-virtual {v2, v3}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    .line 38
    .line 39
    .line 40
    new-instance v3, Ljava/lang/StringBuilder;

    .line 41
    .line 42
    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 43
    .line 44
    .line 45
    const-string v4, "DRM enabled: "

    .line 46
    .line 47
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 48
    .line 49
    .line 50
    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 51
    .line 52
    .line 53
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 54
    .line 55
    .line 56
    move-result-object p2

    .line 57
    invoke-virtual {v2, p2}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    .line 58
    .line 59
    .line 60
    :cond_0
    invoke-direct {p0, p1}, Lcom/amazon/a/g;->a(Landroid/app/Application;)V

    .line 61
    .line 62
    .line 63
    sget-boolean p1, Lcom/amazon/a/a/o/c;->a:Z

    .line 64
    .line 65
    if-eqz p1, :cond_1

    .line 66
    .line 67
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    .line 68
    .line 69
    .line 70
    move-result-wide p1

    .line 71
    sget-object v2, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    .line 72
    .line 73
    new-instance v3, Ljava/lang/StringBuilder;

    .line 74
    .line 75
    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 76
    .line 77
    .line 78
    const-string v4, "Kiwi.Constructor Time: "

    .line 79
    .line 80
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 81
    .line 82
    .line 83
    sub-long/2addr p1, v0

    .line 84
    invoke-virtual {v3, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 85
    .line 86
    .line 87
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 88
    .line 89
    .line 90
    move-result-object p1

    .line 91
    invoke-virtual {v2, p1}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    .line 92
    .line 93
    .line 94
    :cond_1
    return-void
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
.end method

.method public static a(Landroid/app/Activity;I)Landroid/app/Dialog;
    .locals 5

    .line 64
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 65
    const-string v2, "onCreateDialog"

    invoke-static {v2, p0}, Lcom/amazon/a/g;->a(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 66
    sget-object v0, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object v0, v0, Lcom/amazon/a/g;->k:Lcom/amazon/a/a/i/e;

    invoke-interface {v0, p0, p1}, Lcom/amazon/a/a/i/e;->a(Landroid/app/Activity;I)Landroid/app/Dialog;

    move-result-object p0

    return-object p0

    .line 67
    :cond_0
    sget-boolean p0, Lcom/amazon/a/a/o/c;->a:Z

    if-eqz p0, :cond_1

    .line 68
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide p0

    .line 69
    sget-object v2, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Kiwi.ActivityOnCreateDialog Time: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sub-long/2addr p0, v0

    invoke-virtual {v3, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v2, p0}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    :cond_1
    const/4 p0, 0x0

    return-object p0
.end method

.method public static a()Lcom/amazon/a/a/i/e;
    .locals 1

    .line 47
    sget-object v0, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object v0, v0, Lcom/amazon/a/g;->k:Lcom/amazon/a/a/i/e;

    return-object v0
.end method

.method public static a(Landroid/app/Activity;)V
    .locals 6

    .line 58
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 59
    const-string v2, "onResume"

    invoke-static {v2, p0}, Lcom/amazon/a/g;->a(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 60
    sget-object v2, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object v2, v2, Lcom/amazon/a/g;->g:Lcom/amazon/a/a/a/a;

    invoke-interface {v2, p0}, Lcom/amazon/a/a/a/a;->c(Landroid/app/Activity;)V

    .line 61
    :cond_0
    sget-boolean p0, Lcom/amazon/a/a/o/c;->a:Z

    if-eqz p0, :cond_1

    .line 62
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 63
    sget-object p0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Kiwi.ActivityOnResume Time: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sub-long/2addr v2, v0

    invoke-virtual {v4, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    :cond_1
    return-void
.end method

.method public static a(Landroid/app/Activity;Z)V
    .locals 5

    .line 28
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 29
    invoke-static {}, Lcom/amazon/a/g;->c()Z

    move-result v2

    if-nez v2, :cond_0

    .line 30
    new-instance v2, Lcom/amazon/a/g;

    invoke-virtual {p0}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v3

    invoke-direct {v2, v3, p1}, Lcom/amazon/a/g;-><init>(Landroid/app/Application;Z)V

    sput-object v2, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    .line 31
    :cond_0
    const-string p1, "onCreate"

    invoke-static {p1, p0}, Lcom/amazon/a/g;->a(Ljava/lang/String;Landroid/content/Context;)Z

    move-result p1

    if-eqz p1, :cond_1

    .line 32
    sget-object p1, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object p1, p1, Lcom/amazon/a/g;->g:Lcom/amazon/a/a/a/a;

    invoke-interface {p1, p0}, Lcom/amazon/a/a/a/a;->a(Landroid/app/Activity;)V

    .line 33
    :cond_1
    sget-boolean p0, Lcom/amazon/a/a/o/c;->a:Z

    if-eqz p0, :cond_2

    .line 34
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide p0

    .line 35
    sget-object v2, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Kiwi.ActivityOnCreate Time: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sub-long/2addr p0, v0

    invoke-virtual {v3, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v2, p0}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    :cond_2
    return-void
.end method

.method private a(Landroid/app/Application;)V
    .locals 1

    .line 2
    new-instance v0, Lcom/amazon/a/a/k/c;

    invoke-direct {v0}, Lcom/amazon/a/a/k/c;-><init>()V

    .line 3
    invoke-interface {v0, p1}, Lcom/amazon/a/a/k/b;->a(Ljava/lang/Object;)V

    .line 4
    new-instance p1, Lcom/amazon/a/a/n/d;

    invoke-direct {p1}, Lcom/amazon/a/a/n/d;-><init>()V

    .line 5
    invoke-interface {v0, p1}, Lcom/amazon/a/a/k/b;->a(Ljava/lang/Object;)V

    .line 6
    new-instance p1, Lcom/amazon/a/a/m/c;

    invoke-direct {p1}, Lcom/amazon/a/a/m/c;-><init>()V

    .line 7
    invoke-interface {v0, p1}, Lcom/amazon/a/a/k/b;->a(Ljava/lang/Object;)V

    .line 8
    new-instance p1, Lcom/amazon/a/a/l/c;

    invoke-direct {p1}, Lcom/amazon/a/a/l/c;-><init>()V

    .line 9
    invoke-interface {v0, p1}, Lcom/amazon/a/a/k/b;->a(Ljava/lang/Object;)V

    .line 10
    new-instance p1, Lcom/amazon/a/a/a/b;

    invoke-direct {p1}, Lcom/amazon/a/a/a/b;-><init>()V

    .line 11
    invoke-interface {v0, p1}, Lcom/amazon/a/a/k/b;->a(Ljava/lang/Object;)V

    .line 12
    new-instance p1, Lcom/amazon/a/a/i/f;

    invoke-direct {p1}, Lcom/amazon/a/a/i/f;-><init>()V

    .line 13
    invoke-interface {v0, p1}, Lcom/amazon/a/a/k/b;->a(Ljava/lang/Object;)V

    .line 14
    new-instance p1, Lcom/amazon/a/a/c/g;

    invoke-direct {p1}, Lcom/amazon/a/a/c/g;-><init>()V

    .line 15
    invoke-interface {v0, p1}, Lcom/amazon/a/a/k/b;->a(Ljava/lang/Object;)V

    .line 16
    new-instance p1, Lcom/amazon/a/a/b/b;

    invoke-direct {p1}, Lcom/amazon/a/a/b/b;-><init>()V

    .line 17
    invoke-interface {v0, p1}, Lcom/amazon/a/a/k/b;->a(Ljava/lang/Object;)V

    .line 18
    new-instance p1, Lcom/amazon/a/a/h/d;

    invoke-direct {p1}, Lcom/amazon/a/a/h/d;-><init>()V

    .line 19
    invoke-interface {v0, p1}, Lcom/amazon/a/a/k/b;->a(Ljava/lang/Object;)V

    .line 20
    new-instance p1, Lcom/amazon/a/a/n/a/d;

    invoke-direct {p1}, Lcom/amazon/a/a/n/a/d;-><init>()V

    .line 21
    invoke-interface {v0, p1}, Lcom/amazon/a/a/k/b;->a(Ljava/lang/Object;)V

    .line 22
    new-instance p1, Lcom/amazon/a/a/o/b/c;

    invoke-direct {p1}, Lcom/amazon/a/a/o/b/c;-><init>()V

    .line 23
    invoke-interface {v0, p1}, Lcom/amazon/a/a/k/b;->a(Ljava/lang/Object;)V

    .line 24
    new-instance p1, Lcom/amazon/a/a/n/a/b;

    invoke-direct {p1}, Lcom/amazon/a/a/n/a/b;-><init>()V

    .line 25
    invoke-interface {v0, p1}, Lcom/amazon/a/a/k/b;->a(Ljava/lang/Object;)V

    .line 26
    invoke-interface {v0}, Lcom/amazon/a/a/k/b;->a()V

    .line 27
    invoke-interface {v0, p0}, Lcom/amazon/a/a/k/b;->b(Ljava/lang/Object;)V

    return-void
.end method

.method public static a(Landroid/app/Service;)V
    .locals 6

    .line 79
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 80
    const-string v2, "onDestroy"

    invoke-static {v2, p0}, Lcom/amazon/a/g;->a(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 81
    sget-object v2, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object v2, v2, Lcom/amazon/a/g;->g:Lcom/amazon/a/a/a/a;

    invoke-interface {v2, p0}, Lcom/amazon/a/a/a/a;->b(Landroid/app/Service;)V

    .line 82
    :cond_0
    sget-boolean p0, Lcom/amazon/a/a/o/c;->a:Z

    if-eqz p0, :cond_1

    .line 83
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 84
    sget-object p0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Kiwi.ServiceOnDestroy Time: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sub-long/2addr v2, v0

    invoke-virtual {v4, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    :cond_1
    return-void
.end method

.method public static a(Landroid/app/Service;Z)V
    .locals 5

    .line 73
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 74
    const-string p1, "onCreate"

    invoke-static {p1, p0}, Lcom/amazon/a/g;->a(Ljava/lang/String;Landroid/content/Context;)Z

    move-result p1

    if-eqz p1, :cond_0

    .line 75
    sget-object p1, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object p1, p1, Lcom/amazon/a/g;->g:Lcom/amazon/a/a/a/a;

    invoke-interface {p1, p0}, Lcom/amazon/a/a/a/a;->a(Landroid/app/Service;)V

    .line 76
    :cond_0
    sget-boolean p0, Lcom/amazon/a/a/o/c;->a:Z

    if-eqz p0, :cond_1

    .line 77
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide p0

    .line 78
    sget-object v2, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Kiwi.ServiceOnCreate Time: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sub-long/2addr p0, v0

    invoke-virtual {v3, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v2, p0}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    :cond_1
    return-void
.end method

.method public static a(Lcom/amazon/a/a/n/a/a;)V
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 36
    sget-boolean v0, Lcom/amazon/a/a/o/c;->a:Z

    if-eqz v0, :cond_0

    .line 37
    sget-object v0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    const-string v1, "WARNING: Use of deprecated method detected."

    invoke-virtual {v0, v1}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    .line 38
    :cond_0
    invoke-static {}, Lcom/amazon/a/g;->c()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 39
    invoke-static {p0}, Lcom/amazon/a/g;->c(Lcom/amazon/a/a/n/a/a;)V

    return-void

    .line 40
    :cond_1
    sget-object p0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    const-string v0, "Kiwi subsystem is not fully initialized.  Cannot process task."

    invoke-virtual {p0, v0}, Lcom/amazon/a/a/o/c;->b(Ljava/lang/String;)V

    return-void
.end method

.method public static a(Lcom/amazon/a/a/n/a/a;Landroid/content/Context;)V
    .locals 2

    .line 41
    invoke-static {}, Lcom/amazon/a/g;->c()Z

    move-result v0

    if-nez v0, :cond_1

    if-eqz p1, :cond_0

    .line 42
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 43
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p1

    check-cast p1, Landroid/app/Application;

    .line 44
    new-instance v0, Lcom/amazon/a/g;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/amazon/a/g;-><init>(Landroid/app/Application;Z)V

    sput-object v0, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    goto :goto_0

    .line 45
    :cond_0
    sget-object p0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    const-string p1, "Kiwi subsystem cannot be initialized because of null context. Unable to enqueue task."

    invoke-virtual {p0, p1}, Lcom/amazon/a/a/o/c;->b(Ljava/lang/String;)V

    return-void

    .line 46
    :cond_1
    :goto_0
    invoke-static {p0}, Lcom/amazon/a/g;->c(Lcom/amazon/a/a/n/a/a;)V

    return-void
.end method

.method public static synthetic a(Lcom/amazon/a/g;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/amazon/a/g;->h()V

    return-void
.end method

.method public static a(Landroid/app/Activity;IILandroid/content/Intent;)Z
    .locals 1

    .line 70
    const-string v0, "onActivityResult"

    invoke-static {v0, p0}, Lcom/amazon/a/g;->a(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 71
    new-instance v0, Lcom/amazon/a/a/l/a;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/amazon/a/a/l/a;-><init>(Landroid/app/Activity;IILandroid/content/Intent;)V

    .line 72
    sget-object p0, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object p0, p0, Lcom/amazon/a/g;->h:Lcom/amazon/a/a/l/b;

    invoke-interface {p0, v0}, Lcom/amazon/a/a/l/b;->a(Lcom/amazon/a/a/l/a;)Z

    move-result p0

    return p0

    :cond_0
    const/4 p0, 0x0

    return p0
.end method

.method private static a(Ljava/lang/String;Landroid/content/Context;)Z
    .locals 3

    .line 53
    invoke-static {}, Lcom/amazon/a/a/o/a/a;->a()V

    .line 54
    sget-boolean v0, Lcom/amazon/a/a/o/c;->a:Z

    if-eqz v0, :cond_0

    .line 55
    sget-object v0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    .line 56
    :cond_0
    invoke-static {}, Lcom/amazon/a/g;->c()Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 p0, 0x1

    return p0

    .line 57
    :cond_1
    invoke-static {p0, p1}, Lcom/amazon/a/g;->b(Ljava/lang/String;Landroid/content/Context;)V

    const/4 p0, 0x0

    return p0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2

    .line 48
    invoke-static {}, Lcom/amazon/a/g;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 49
    :try_start_0
    sget-object v0, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object v0, v0, Lcom/amazon/a/g;->n:Lcom/amazon/a/a/o/b/b;

    invoke-interface {v0}, Lcom/amazon/a/a/o/b/b;->a()Ljava/security/PublicKey;

    move-result-object v0

    .line 50
    invoke-static {p0, p1, v0}, Lcom/amazon/a/a/o/b/e;->a(Ljava/lang/String;Ljava/lang/String;Ljava/security/PublicKey;)Z

    move-result p0
    :try_end_0
    .catch Lcom/amazon/a/a/o/b/a/a; {:try_start_0 .. :try_end_0} :catch_0

    return p0

    :catch_0
    move-exception p0

    .line 51
    sget-object p1, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Unable to validate signature: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p1, p0}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 52
    :cond_0
    sget-object p0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    const-string p1, "Kiwi was not yet initialized - cannot do the IAP call"

    invoke-virtual {p0, p1}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    :goto_0
    const/4 p0, 0x0

    return p0
.end method

.method public static synthetic b(Lcom/amazon/a/g;)Landroid/app/Application;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/amazon/a/g;->m:Landroid/app/Application;

    return-object p0
.end method

.method public static synthetic b()Lcom/amazon/a/a/o/c;
    .locals 1

    .line 2
    sget-object v0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    return-object v0
.end method

.method public static b(Landroid/app/Activity;)V
    .locals 6

    .line 6
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 7
    const-string v2, "onPause"

    invoke-static {v2, p0}, Lcom/amazon/a/g;->a(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 8
    sget-object v2, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object v2, v2, Lcom/amazon/a/g;->g:Lcom/amazon/a/a/a/a;

    invoke-interface {v2, p0}, Lcom/amazon/a/a/a/a;->d(Landroid/app/Activity;)V

    .line 9
    :cond_0
    sget-boolean p0, Lcom/amazon/a/a/o/c;->a:Z

    if-eqz p0, :cond_1

    .line 10
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 11
    sget-object p0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Kiwi.ActivityOnPause Time: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sub-long/2addr v2, v0

    invoke-virtual {v4, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    :cond_1
    return-void
.end method

.method public static b(Landroid/app/Activity;Z)V
    .locals 1

    .line 12
    const-string v0, "onWindowFocusChanged"

    invoke-static {v0, p0}, Lcom/amazon/a/g;->a(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 13
    sget-object v0, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object v0, v0, Lcom/amazon/a/g;->k:Lcom/amazon/a/a/i/e;

    invoke-interface {v0, p0, p1}, Lcom/amazon/a/a/i/e;->a(Landroid/app/Activity;Z)V

    :cond_0
    return-void
.end method

.method public static synthetic b(Lcom/amazon/a/a/n/a/a;)V
    .locals 0

    .line 3
    invoke-static {p0}, Lcom/amazon/a/g;->c(Lcom/amazon/a/a/n/a/a;)V

    return-void
.end method

.method private static b(Ljava/lang/String;Landroid/content/Context;)V
    .locals 2

    .line 4
    sget-boolean v0, Lcom/amazon/a/a/o/c;->a:Z

    if-eqz v0, :cond_0

    .line 5
    sget-object v0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, " called on context: "

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string p0, " when Kiwi is dead, ignoring..."

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method public static synthetic c(Lcom/amazon/a/g;)Lcom/amazon/a/g;
    .locals 0

    .line 1
    sput-object p0, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    return-object p0
.end method

.method public static c(Landroid/app/Activity;)V
    .locals 6

    .line 4
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 5
    const-string v2, "onDestroy"

    invoke-static {v2, p0}, Lcom/amazon/a/g;->a(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 6
    :try_start_0
    sget-object v2, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object v2, v2, Lcom/amazon/a/g;->g:Lcom/amazon/a/a/a/a;

    invoke-interface {v2, p0}, Lcom/amazon/a/a/a/a;->b(Landroid/app/Activity;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p0

    .line 7
    sget-object v2, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    const-string v3, "Kiwi.ActivityOnDestroy Error: "

    invoke-virtual {v2, v3, p0}, Lcom/amazon/a/a/o/c;->b(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 8
    :cond_0
    :goto_0
    sget-boolean p0, Lcom/amazon/a/a/o/c;->a:Z

    if-eqz p0, :cond_1

    .line 9
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 10
    sget-object p0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Kiwi.ActivityOnDestroy Time: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sub-long/2addr v2, v0

    invoke-virtual {v4, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    :cond_1
    return-void
.end method

.method private static c(Lcom/amazon/a/a/n/a/a;)V
    .locals 2

    .line 2
    sget-object v0, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object v0, v0, Lcom/amazon/a/g;->j:Lcom/amazon/a/a/n/b;

    sget-object v1, Lcom/amazon/a/a/n/b/d;->b:Lcom/amazon/a/a/n/b/d;

    invoke-interface {v0, v1, p0}, Lcom/amazon/a/a/n/b;->a(Lcom/amazon/a/a/n/b/d;Lcom/amazon/a/a/n/a;)V

    return-void
.end method

.method private static c()Z
    .locals 1

    .line 3
    sget-object v0, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    return v0

    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method private d()V
    .locals 2

    .line 7
    new-instance v0, Lcom/amazon/a/g$1;

    invoke-direct {v0, p0}, Lcom/amazon/a/g$1;-><init>(Lcom/amazon/a/g;)V

    .line 8
    iget-object v1, p0, Lcom/amazon/a/g;->i:Lcom/amazon/a/a/c/f;

    invoke-interface {v1, v0}, Lcom/amazon/a/a/c/f;->a(Lcom/amazon/a/a/c/c;)V

    return-void
.end method

.method public static d(Landroid/app/Activity;)V
    .locals 6

    .line 1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 2
    const-string v2, "onStart"

    invoke-static {v2, p0}, Lcom/amazon/a/g;->a(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 3
    sget-object v2, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object v2, v2, Lcom/amazon/a/g;->g:Lcom/amazon/a/a/a/a;

    invoke-interface {v2, p0}, Lcom/amazon/a/a/a/a;->e(Landroid/app/Activity;)V

    .line 4
    :cond_0
    sget-boolean p0, Lcom/amazon/a/a/o/c;->a:Z

    if-eqz p0, :cond_1

    .line 5
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 6
    sget-object p0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Kiwi.ActivityOnStart Time: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sub-long/2addr v2, v0

    invoke-virtual {v4, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    :cond_1
    return-void
.end method

.method public static e(Landroid/app/Activity;)V
    .locals 6

    .line 1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 2
    const-string v2, "onStop"

    invoke-static {v2, p0}, Lcom/amazon/a/g;->a(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 3
    sget-object v2, Lcom/amazon/a/g;->e:Lcom/amazon/a/g;

    iget-object v2, v2, Lcom/amazon/a/g;->g:Lcom/amazon/a/a/a/a;

    invoke-interface {v2, p0}, Lcom/amazon/a/a/a/a;->f(Landroid/app/Activity;)V

    .line 4
    :cond_0
    sget-boolean p0, Lcom/amazon/a/a/o/c;->a:Z

    if-eqz p0, :cond_1

    .line 5
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 6
    sget-object p0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Kiwi.ActivityOnStop Time: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sub-long/2addr v2, v0

    invoke-virtual {v4, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    :cond_1
    return-void
.end method

.method private f()V
    .locals 2

    .line 1
    new-instance v0, Lcom/amazon/a/g$2;

    .line 2
    .line 3
    invoke-direct {v0, p0}, Lcom/amazon/a/g$2;-><init>(Lcom/amazon/a/g;)V

    .line 4
    .line 5
    .line 6
    iget-object v1, p0, Lcom/amazon/a/g;->i:Lcom/amazon/a/a/c/f;

    .line 7
    .line 8
    invoke-interface {v1, v0}, Lcom/amazon/a/a/c/f;->a(Lcom/amazon/a/a/c/c;)V

    .line 9
    .line 10
    .line 11
    return-void
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method private g()V
    .locals 2

    .line 1
    new-instance v0, Lcom/amazon/a/g$3;

    .line 2
    .line 3
    invoke-direct {v0, p0}, Lcom/amazon/a/g$3;-><init>(Lcom/amazon/a/g;)V

    .line 4
    .line 5
    .line 6
    iget-object v1, p0, Lcom/amazon/a/g;->i:Lcom/amazon/a/a/c/f;

    .line 7
    .line 8
    invoke-interface {v1, v0}, Lcom/amazon/a/a/c/f;->a(Lcom/amazon/a/a/c/c;)V

    .line 9
    .line 10
    .line 11
    return-void
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method private h()V
    .locals 3

    .line 1
    sget-boolean v0, Lcom/amazon/a/a/o/c;->a:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    sget-object v0, Lcom/amazon/a/g;->d:Lcom/amazon/a/a/o/c;

    .line 6
    .line 7
    const-string v1, "Enqueuing launch workflow"

    .line 8
    .line 9
    invoke-virtual {v0, v1}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    .line 10
    .line 11
    .line 12
    :cond_0
    invoke-direct {p0}, Lcom/amazon/a/g;->i()Lcom/amazon/a/a/n/a;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    iget-object v1, p0, Lcom/amazon/a/g;->j:Lcom/amazon/a/a/n/b;

    .line 17
    .line 18
    sget-object v2, Lcom/amazon/a/a/n/b/d;->b:Lcom/amazon/a/a/n/b/d;

    .line 19
    .line 20
    invoke-interface {v1, v2, v0}, Lcom/amazon/a/a/n/b;->a(Lcom/amazon/a/a/n/b/d;Lcom/amazon/a/a/n/a;)V

    .line 21
    .line 22
    .line 23
    return-void
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
.end method

.method private i()Lcom/amazon/a/a/n/a;
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/amazon/a/g;->f:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    new-instance v0, Lcom/amazon/a/f;

    .line 6
    .line 7
    invoke-direct {v0}, Lcom/amazon/a/f;-><init>()V

    .line 8
    .line 9
    .line 10
    return-object v0

    .line 11
    :cond_0
    new-instance v0, Lcom/amazon/a/e;

    .line 12
    .line 13
    invoke-direct {v0}, Lcom/amazon/a/e;-><init>()V

    .line 14
    .line 15
    .line 16
    return-object v0
.end method

.method private j()V
    .locals 2

    .line 1
    new-instance v0, Lcom/amazon/a/g$4;

    .line 2
    .line 3
    invoke-direct {v0, p0}, Lcom/amazon/a/g$4;-><init>(Lcom/amazon/a/g;)V

    .line 4
    .line 5
    .line 6
    iget-object v1, p0, Lcom/amazon/a/g;->i:Lcom/amazon/a/a/c/f;

    .line 7
    .line 8
    invoke-interface {v1, v0}, Lcom/amazon/a/a/c/f;->a(Lcom/amazon/a/a/c/c;)V

    .line 9
    .line 10
    .line 11
    return-void
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method


# virtual methods
.method public e()V
    .locals 0

    .line 7
    invoke-direct {p0}, Lcom/amazon/a/g;->g()V

    .line 8
    invoke-direct {p0}, Lcom/amazon/a/g;->j()V

    .line 9
    invoke-direct {p0}, Lcom/amazon/a/g;->d()V

    .line 10
    invoke-direct {p0}, Lcom/amazon/a/g;->f()V

    return-void
.end method
