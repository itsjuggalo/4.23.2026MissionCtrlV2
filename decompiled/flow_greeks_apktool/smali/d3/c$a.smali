.class public final Ld3/c$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ld3/c;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public volatile a:Ld3/o;

.field public final b:Landroid/content/Context;

.field public volatile c:Ld3/s;

.field public volatile d:Z

.field public volatile e:Z

.field public volatile f:Z


# direct methods
.method public synthetic constructor <init>(Landroid/content/Context;Ld3/j2;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Ld3/c$a;->b:Landroid/content/Context;

    .line 5
    .line 6
    return-void
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
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
.end method


# virtual methods
.method public a()Ld3/c;
    .locals 9

    .line 1
    iget-object v3, p0, Ld3/c$a;->b:Landroid/content/Context;

    .line 2
    .line 3
    if-eqz v3, :cond_8

    .line 4
    .line 5
    iget-object v0, p0, Ld3/c$a;->c:Ld3/s;

    .line 6
    .line 7
    if-nez v0, :cond_3

    .line 8
    .line 9
    iget-boolean v0, p0, Ld3/c$a;->d:Z

    .line 10
    .line 11
    if-nez v0, :cond_1

    .line 12
    .line 13
    iget-boolean v0, p0, Ld3/c$a;->e:Z

    .line 14
    .line 15
    if-eqz v0, :cond_0

    .line 16
    .line 17
    goto :goto_0

    .line 18
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 19
    .line 20
    const-string v1, "Please provide a valid listener for purchases updates."

    .line 21
    .line 22
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 23
    .line 24
    .line 25
    throw v0

    .line 26
    :cond_1
    :goto_0
    invoke-virtual {p0}, Ld3/c$a;->d()Z

    .line 27
    .line 28
    .line 29
    move-result v0

    .line 30
    if-eqz v0, :cond_2

    .line 31
    .line 32
    new-instance v0, Ld3/m1;

    .line 33
    .line 34
    move-object v2, v3

    .line 35
    const/4 v3, 0x0

    .line 36
    const/4 v4, 0x0

    .line 37
    const/4 v1, 0x0

    .line 38
    move-object v5, p0

    .line 39
    invoke-direct/range {v0 .. v5}, Ld3/m1;-><init>(Ljava/lang/String;Landroid/content/Context;Ld3/p1;Ljava/util/concurrent/ExecutorService;Ld3/c$a;)V

    .line 40
    .line 41
    .line 42
    return-object v0

    .line 43
    :cond_2
    new-instance v0, Ld3/d;

    .line 44
    .line 45
    move-object v2, v3

    .line 46
    const/4 v3, 0x0

    .line 47
    const/4 v4, 0x0

    .line 48
    const/4 v1, 0x0

    .line 49
    move-object v5, p0

    .line 50
    invoke-direct/range {v0 .. v5}, Ld3/d;-><init>(Ljava/lang/String;Landroid/content/Context;Ld3/p1;Ljava/util/concurrent/ExecutorService;Ld3/c$a;)V

    .line 51
    .line 52
    .line 53
    return-object v0

    .line 54
    :cond_3
    move-object v5, p0

    .line 55
    iget-object v0, v5, Ld3/c$a;->a:Ld3/o;

    .line 56
    .line 57
    if-eqz v0, :cond_7

    .line 58
    .line 59
    iget-object v0, v5, Ld3/c$a;->a:Ld3/o;

    .line 60
    .line 61
    invoke-virtual {v0}, Ld3/o;->a()Z

    .line 62
    .line 63
    .line 64
    move-result v0

    .line 65
    if-eqz v0, :cond_7

    .line 66
    .line 67
    iget-object v0, v5, Ld3/c$a;->c:Ld3/s;

    .line 68
    .line 69
    if-eqz v0, :cond_5

    .line 70
    .line 71
    iget-object v2, v5, Ld3/c$a;->a:Ld3/o;

    .line 72
    .line 73
    iget-object v4, v5, Ld3/c$a;->c:Ld3/s;

    .line 74
    .line 75
    invoke-virtual {p0}, Ld3/c$a;->d()Z

    .line 76
    .line 77
    .line 78
    move-result v0

    .line 79
    if-eqz v0, :cond_4

    .line 80
    .line 81
    new-instance v0, Ld3/m1;

    .line 82
    .line 83
    const/4 v6, 0x0

    .line 84
    const/4 v7, 0x0

    .line 85
    const/4 v1, 0x0

    .line 86
    const/4 v5, 0x0

    .line 87
    move-object v8, p0

    .line 88
    invoke-direct/range {v0 .. v8}, Ld3/m1;-><init>(Ljava/lang/String;Ld3/o;Landroid/content/Context;Ld3/s;Ld3/p0;Ld3/p1;Ljava/util/concurrent/ExecutorService;Ld3/c$a;)V

    .line 89
    .line 90
    .line 91
    return-object v0

    .line 92
    :cond_4
    new-instance v0, Ld3/d;

    .line 93
    .line 94
    const/4 v6, 0x0

    .line 95
    const/4 v7, 0x0

    .line 96
    const/4 v1, 0x0

    .line 97
    const/4 v5, 0x0

    .line 98
    move-object v8, p0

    .line 99
    invoke-direct/range {v0 .. v8}, Ld3/d;-><init>(Ljava/lang/String;Ld3/o;Landroid/content/Context;Ld3/s;Ld3/p0;Ld3/p1;Ljava/util/concurrent/ExecutorService;Ld3/c$a;)V

    .line 100
    .line 101
    .line 102
    move-object v5, v8

    .line 103
    return-object v0

    .line 104
    :cond_5
    iget-object v2, v5, Ld3/c$a;->a:Ld3/o;

    .line 105
    .line 106
    invoke-virtual {p0}, Ld3/c$a;->d()Z

    .line 107
    .line 108
    .line 109
    move-result v0

    .line 110
    if-eqz v0, :cond_6

    .line 111
    .line 112
    new-instance v0, Ld3/m1;

    .line 113
    .line 114
    const/4 v5, 0x0

    .line 115
    const/4 v6, 0x0

    .line 116
    const/4 v1, 0x0

    .line 117
    const/4 v4, 0x0

    .line 118
    move-object v7, p0

    .line 119
    invoke-direct/range {v0 .. v7}, Ld3/m1;-><init>(Ljava/lang/String;Ld3/o;Landroid/content/Context;Ld3/v1;Ld3/p1;Ljava/util/concurrent/ExecutorService;Ld3/c$a;)V

    .line 120
    .line 121
    .line 122
    return-object v0

    .line 123
    :cond_6
    new-instance v0, Ld3/d;

    .line 124
    .line 125
    const/4 v5, 0x0

    .line 126
    const/4 v6, 0x0

    .line 127
    const/4 v1, 0x0

    .line 128
    const/4 v4, 0x0

    .line 129
    move-object v7, p0

    .line 130
    invoke-direct/range {v0 .. v7}, Ld3/d;-><init>(Ljava/lang/String;Ld3/o;Landroid/content/Context;Ld3/v1;Ld3/p1;Ljava/util/concurrent/ExecutorService;Ld3/c$a;)V

    .line 131
    .line 132
    .line 133
    return-object v0

    .line 134
    :cond_7
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 135
    .line 136
    const-string v1, "Pending purchases for one-time products must be supported."

    .line 137
    .line 138
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 139
    .line 140
    .line 141
    throw v0

    .line 142
    :cond_8
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 143
    .line 144
    const-string v1, "Please provide a valid Context."

    .line 145
    .line 146
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 147
    .line 148
    .line 149
    throw v0
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
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
.end method

.method public b(Ld3/o;)Ld3/c$a;
    .locals 0

    .line 1
    iput-object p1, p0, Ld3/c$a;->a:Ld3/o;

    .line 2
    .line 3
    return-object p0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public c(Ld3/s;)Ld3/c$a;
    .locals 0

    .line 1
    iput-object p1, p0, Ld3/c$a;->c:Ld3/s;

    .line 2
    .line 3
    return-object p0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public final d()Z
    .locals 4

    .line 1
    const/4 v0, 0x0

    .line 2
    :try_start_0
    iget-object v1, p0, Ld3/c$a;->b:Landroid/content/Context;

    .line 3
    .line 4
    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 5
    .line 6
    .line 7
    move-result-object v2

    .line 8
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    .line 9
    .line 10
    .line 11
    move-result-object v1

    .line 12
    const/16 v3, 0x80

    .line 13
    .line 14
    invoke-virtual {v2, v1, v3}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    .line 15
    .line 16
    .line 17
    move-result-object v1

    .line 18
    iget-object v1, v1, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    .line 19
    .line 20
    const-string v2, "com.google.android.play.billingclient.enableBillingOverridesTesting"

    .line 21
    .line 22
    invoke-virtual {v1, v2, v0}, Landroid/os/BaseBundle;->getBoolean(Ljava/lang/String;Z)Z

    .line 23
    .line 24
    .line 25
    move-result v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 26
    return v0

    .line 27
    :catch_0
    move-exception v1

    .line 28
    const-string v2, "BillingClient"

    .line 29
    .line 30
    const-string v3, "Unable to retrieve metadata value for enableBillingOverridesTesting."

    .line 31
    .line 32
    invoke-static {v2, v3, v1}, Lcom/google/android/gms/internal/play_billing/zzc;->zzo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 33
    .line 34
    .line 35
    return v0
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
