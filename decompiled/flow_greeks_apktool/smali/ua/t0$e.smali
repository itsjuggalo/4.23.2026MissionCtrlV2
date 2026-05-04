.class public final Lua/t0$e;
.super Lid/m;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lpd/o;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lua/t0;->c()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation


# instance fields
.field public a:I

.field public final synthetic b:Lua/t0;

.field public final synthetic c:Lua/e0;


# direct methods
.method public constructor <init>(Lua/t0;Lua/e0;Lgd/e;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lua/t0$e;->b:Lua/t0;

    .line 2
    .line 3
    iput-object p2, p0, Lua/t0$e;->c:Lua/e0;

    .line 4
    .line 5
    const/4 p1, 0x2

    .line 6
    invoke-direct {p0, p1, p3}, Lid/m;-><init>(ILgd/e;)V

    .line 7
    .line 8
    .line 9
    return-void
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
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
.end method


# virtual methods
.method public final create(Ljava/lang/Object;Lgd/e;)Lgd/e;
    .locals 2

    .line 1
    new-instance p1, Lua/t0$e;

    .line 2
    .line 3
    iget-object v0, p0, Lua/t0$e;->b:Lua/t0;

    .line 4
    .line 5
    iget-object v1, p0, Lua/t0$e;->c:Lua/e0;

    .line 6
    .line 7
    invoke-direct {p1, v0, v1, p2}, Lua/t0$e;-><init>(Lua/t0;Lua/e0;Lgd/e;)V

    .line 8
    .line 9
    .line 10
    return-object p1
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

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 1
    check-cast p1, Lng/n0;

    check-cast p2, Lgd/e;

    invoke-virtual {p0, p1, p2}, Lua/t0$e;->invoke(Lng/n0;Lgd/e;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final invoke(Lng/n0;Lgd/e;)Ljava/lang/Object;
    .locals 0

    .line 2
    invoke-virtual {p0, p1, p2}, Lua/t0$e;->create(Ljava/lang/Object;Lgd/e;)Lgd/e;

    move-result-object p1

    check-cast p1, Lua/t0$e;

    sget-object p2, Lcd/h0;->a:Lcd/h0;

    invoke-virtual {p1, p2}, Lua/t0$e;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 9

    .line 1
    invoke-static {}, Lhd/c;->f()Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object v1

    .line 5
    iget v0, p0, Lua/t0$e;->a:I

    .line 6
    .line 7
    const/4 v2, 0x2

    .line 8
    const/4 v3, 0x1

    .line 9
    if-eqz v0, :cond_2

    .line 10
    .line 11
    if-eq v0, v3, :cond_1

    .line 12
    .line 13
    if-ne v0, v2, :cond_0

    .line 14
    .line 15
    invoke-static {p1}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 16
    .line 17
    .line 18
    goto/16 :goto_2

    .line 19
    .line 20
    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 21
    .line 22
    const-string v0, "call to \'resume\' before \'invoke\' with coroutine"

    .line 23
    .line 24
    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 25
    .line 26
    .line 27
    throw p1

    .line 28
    :cond_1
    :try_start_0
    invoke-static {p1}, Lcd/s;->b(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 29
    .line 30
    .line 31
    goto/16 :goto_2

    .line 32
    .line 33
    :catch_0
    move-exception v0

    .line 34
    move-object p1, v0

    .line 35
    goto :goto_0

    .line 36
    :cond_2
    invoke-static {p1}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 37
    .line 38
    .line 39
    :try_start_1
    iget-object p1, p0, Lua/t0$e;->b:Lua/t0;

    .line 40
    .line 41
    invoke-static {p1}, Lua/t0;->e(Lua/t0;)Ll1/i;

    .line 42
    .line 43
    .line 44
    move-result-object p1

    .line 45
    new-instance v0, Lua/t0$e$a;

    .line 46
    .line 47
    iget-object v4, p0, Lua/t0$e;->b:Lua/t0;

    .line 48
    .line 49
    const/4 v5, 0x0

    .line 50
    invoke-direct {v0, v4, v5}, Lua/t0$e$a;-><init>(Lua/t0;Lgd/e;)V

    .line 51
    .line 52
    .line 53
    iput v3, p0, Lua/t0$e;->a:I

    .line 54
    .line 55
    invoke-interface {p1, v0, p0}, Ll1/i;->a(Lpd/o;Lgd/e;)Ljava/lang/Object;

    .line 56
    .line 57
    .line 58
    move-result-object p1
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 59
    if-ne p1, v1, :cond_3

    .line 60
    .line 61
    goto :goto_1

    .line 62
    :goto_0
    new-instance v0, Ljava/lang/StringBuilder;

    .line 63
    .line 64
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 65
    .line 66
    .line 67
    const-string v3, "App foregrounded, failed to update data. Message: "

    .line 68
    .line 69
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 70
    .line 71
    .line 72
    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    .line 73
    .line 74
    .line 75
    move-result-object p1

    .line 76
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 77
    .line 78
    .line 79
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 80
    .line 81
    .line 82
    move-result-object p1

    .line 83
    const-string v0, "FirebaseSessions"

    .line 84
    .line 85
    invoke-static {v0, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 86
    .line 87
    .line 88
    iget-object p1, p0, Lua/t0$e;->b:Lua/t0;

    .line 89
    .line 90
    iget-object v0, p0, Lua/t0$e;->c:Lua/e0;

    .line 91
    .line 92
    invoke-static {p1, v0}, Lua/t0;->k(Lua/t0;Lua/e0;)Z

    .line 93
    .line 94
    .line 95
    move-result p1

    .line 96
    if-eqz p1, :cond_3

    .line 97
    .line 98
    iget-object p1, p0, Lua/t0$e;->b:Lua/t0;

    .line 99
    .line 100
    invoke-static {p1}, Lua/t0;->g(Lua/t0;)Lua/n0;

    .line 101
    .line 102
    .line 103
    move-result-object p1

    .line 104
    iget-object v0, p0, Lua/t0$e;->c:Lua/e0;

    .line 105
    .line 106
    invoke-virtual {v0}, Lua/e0;->f()Lua/h0;

    .line 107
    .line 108
    .line 109
    move-result-object v0

    .line 110
    invoke-virtual {p1, v0}, Lua/n0;->a(Lua/h0;)Lua/h0;

    .line 111
    .line 112
    .line 113
    move-result-object v4

    .line 114
    iget-object p1, p0, Lua/t0$e;->b:Lua/t0;

    .line 115
    .line 116
    iget-object v3, p0, Lua/t0$e;->c:Lua/e0;

    .line 117
    .line 118
    const/4 v7, 0x4

    .line 119
    const/4 v8, 0x0

    .line 120
    const/4 v5, 0x0

    .line 121
    const/4 v6, 0x0

    .line 122
    invoke-static/range {v3 .. v8}, Lua/e0;->c(Lua/e0;Lua/h0;Lua/v0;Ljava/util/Map;ILjava/lang/Object;)Lua/e0;

    .line 123
    .line 124
    .line 125
    move-result-object v0

    .line 126
    invoke-virtual {p1, v0}, Lua/t0;->r(Lua/e0;)V

    .line 127
    .line 128
    .line 129
    iget-object p1, p0, Lua/t0$e;->b:Lua/t0;

    .line 130
    .line 131
    invoke-static {p1}, Lua/t0;->f(Lua/t0;)Lua/k0;

    .line 132
    .line 133
    .line 134
    move-result-object p1

    .line 135
    invoke-interface {p1, v4}, Lua/k0;->a(Lua/h0;)V

    .line 136
    .line 137
    .line 138
    iget-object p1, p0, Lua/t0$e;->b:Lua/t0;

    .line 139
    .line 140
    invoke-virtual {v4}, Lua/h0;->b()Ljava/lang/String;

    .line 141
    .line 142
    .line 143
    move-result-object v0

    .line 144
    sget-object v3, Lua/t0$b;->b:Lua/t0$b;

    .line 145
    .line 146
    iput v2, p0, Lua/t0$e;->a:I

    .line 147
    .line 148
    invoke-static {p1, v0, v3, p0}, Lua/t0;->l(Lua/t0;Ljava/lang/String;Lua/t0$b;Lgd/e;)Ljava/lang/Object;

    .line 149
    .line 150
    .line 151
    move-result-object p1

    .line 152
    if-ne p1, v1, :cond_3

    .line 153
    .line 154
    :goto_1
    return-object v1

    .line 155
    :cond_3
    :goto_2
    sget-object p1, Lcd/h0;->a:Lcd/h0;

    .line 156
    .line 157
    return-object p1
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
    .line 197
.end method
