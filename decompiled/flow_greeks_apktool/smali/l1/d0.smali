.class public abstract Ll1/d0;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final a:Lwg/a;

.field public final b:Lng/x;


# direct methods
.method public constructor <init>()V
    .locals 3

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    const/4 v1, 0x1

    .line 6
    const/4 v2, 0x0

    .line 7
    invoke-static {v0, v1, v2}, Lwg/g;->b(ZILjava/lang/Object;)Lwg/a;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    iput-object v0, p0, Ll1/d0;->a:Lwg/a;

    .line 12
    .line 13
    invoke-static {v2, v1, v2}, Lng/z;->b(Lng/y1;ILjava/lang/Object;)Lng/x;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    iput-object v0, p0, Ll1/d0;->b:Lng/x;

    .line 18
    .line 19
    return-void
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
.end method


# virtual methods
.method public final a(Lgd/e;)Ljava/lang/Object;
    .locals 1

    .line 1
    iget-object v0, p0, Ll1/d0;->b:Lng/x;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Lng/u0;->await(Lgd/e;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    invoke-static {}, Lhd/c;->f()Ljava/lang/Object;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    if-ne p1, v0, :cond_0

    .line 12
    .line 13
    return-object p1

    .line 14
    :cond_0
    sget-object p1, Lcd/h0;->a:Lcd/h0;

    .line 15
    .line 16
    return-object p1
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public abstract b(Lgd/e;)Ljava/lang/Object;
.end method

.method public final c(Lgd/e;)Ljava/lang/Object;
    .locals 6

    .line 1
    instance-of v0, p1, Ll1/d0$a;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    move-object v0, p1

    .line 6
    check-cast v0, Ll1/d0$a;

    .line 7
    .line 8
    iget v1, v0, Ll1/d0$a;->e:I

    .line 9
    .line 10
    const/high16 v2, -0x80000000

    .line 11
    .line 12
    and-int v3, v1, v2

    .line 13
    .line 14
    if-eqz v3, :cond_0

    .line 15
    .line 16
    sub-int/2addr v1, v2

    .line 17
    iput v1, v0, Ll1/d0$a;->e:I

    .line 18
    .line 19
    goto :goto_0

    .line 20
    :cond_0
    new-instance v0, Ll1/d0$a;

    .line 21
    .line 22
    invoke-direct {v0, p0, p1}, Ll1/d0$a;-><init>(Ll1/d0;Lgd/e;)V

    .line 23
    .line 24
    .line 25
    :goto_0
    iget-object p1, v0, Ll1/d0$a;->c:Ljava/lang/Object;

    .line 26
    .line 27
    invoke-static {}, Lhd/c;->f()Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object v1

    .line 31
    iget v2, v0, Ll1/d0$a;->e:I

    .line 32
    .line 33
    const/4 v3, 0x2

    .line 34
    const/4 v4, 0x1

    .line 35
    const/4 v5, 0x0

    .line 36
    if-eqz v2, :cond_3

    .line 37
    .line 38
    if-eq v2, v4, :cond_2

    .line 39
    .line 40
    if-ne v2, v3, :cond_1

    .line 41
    .line 42
    iget-object v1, v0, Ll1/d0$a;->b:Ljava/lang/Object;

    .line 43
    .line 44
    check-cast v1, Lwg/a;

    .line 45
    .line 46
    iget-object v0, v0, Ll1/d0$a;->a:Ljava/lang/Object;

    .line 47
    .line 48
    check-cast v0, Ll1/d0;

    .line 49
    .line 50
    :try_start_0
    invoke-static {p1}, Lcd/s;->b(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 51
    .line 52
    .line 53
    goto :goto_3

    .line 54
    :catchall_0
    move-exception p1

    .line 55
    goto :goto_4

    .line 56
    :cond_1
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 57
    .line 58
    const-string v0, "call to \'resume\' before \'invoke\' with coroutine"

    .line 59
    .line 60
    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 61
    .line 62
    .line 63
    throw p1

    .line 64
    :cond_2
    iget-object v2, v0, Ll1/d0$a;->b:Ljava/lang/Object;

    .line 65
    .line 66
    check-cast v2, Lwg/a;

    .line 67
    .line 68
    iget-object v4, v0, Ll1/d0$a;->a:Ljava/lang/Object;

    .line 69
    .line 70
    check-cast v4, Ll1/d0;

    .line 71
    .line 72
    invoke-static {p1}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 73
    .line 74
    .line 75
    move-object p1, v2

    .line 76
    goto :goto_1

    .line 77
    :cond_3
    invoke-static {p1}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 78
    .line 79
    .line 80
    iget-object p1, p0, Ll1/d0;->b:Lng/x;

    .line 81
    .line 82
    invoke-interface {p1}, Lng/y1;->isCompleted()Z

    .line 83
    .line 84
    .line 85
    move-result p1

    .line 86
    if-eqz p1, :cond_4

    .line 87
    .line 88
    sget-object p1, Lcd/h0;->a:Lcd/h0;

    .line 89
    .line 90
    return-object p1

    .line 91
    :cond_4
    iget-object p1, p0, Ll1/d0;->a:Lwg/a;

    .line 92
    .line 93
    iput-object p0, v0, Ll1/d0$a;->a:Ljava/lang/Object;

    .line 94
    .line 95
    iput-object p1, v0, Ll1/d0$a;->b:Ljava/lang/Object;

    .line 96
    .line 97
    iput v4, v0, Ll1/d0$a;->e:I

    .line 98
    .line 99
    invoke-interface {p1, v5, v0}, Lwg/a;->d(Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;

    .line 100
    .line 101
    .line 102
    move-result-object v2

    .line 103
    if-ne v2, v1, :cond_5

    .line 104
    .line 105
    goto :goto_2

    .line 106
    :cond_5
    move-object v4, p0

    .line 107
    :goto_1
    :try_start_1
    iget-object v2, v4, Ll1/d0;->b:Lng/x;

    .line 108
    .line 109
    invoke-interface {v2}, Lng/y1;->isCompleted()Z

    .line 110
    .line 111
    .line 112
    move-result v2

    .line 113
    if-eqz v2, :cond_6

    .line 114
    .line 115
    sget-object v0, Lcd/h0;->a:Lcd/h0;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 116
    .line 117
    invoke-interface {p1, v5}, Lwg/a;->c(Ljava/lang/Object;)V

    .line 118
    .line 119
    .line 120
    return-object v0

    .line 121
    :catchall_1
    move-exception v0

    .line 122
    move-object v1, p1

    .line 123
    move-object p1, v0

    .line 124
    goto :goto_4

    .line 125
    :cond_6
    :try_start_2
    iput-object v4, v0, Ll1/d0$a;->a:Ljava/lang/Object;

    .line 126
    .line 127
    iput-object p1, v0, Ll1/d0$a;->b:Ljava/lang/Object;

    .line 128
    .line 129
    iput v3, v0, Ll1/d0$a;->e:I

    .line 130
    .line 131
    invoke-virtual {v4, v0}, Ll1/d0;->b(Lgd/e;)Ljava/lang/Object;

    .line 132
    .line 133
    .line 134
    move-result-object v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 135
    if-ne v0, v1, :cond_7

    .line 136
    .line 137
    :goto_2
    return-object v1

    .line 138
    :cond_7
    move-object v1, p1

    .line 139
    move-object v0, v4

    .line 140
    :goto_3
    :try_start_3
    iget-object p1, v0, Ll1/d0;->b:Lng/x;

    .line 141
    .line 142
    sget-object v0, Lcd/h0;->a:Lcd/h0;

    .line 143
    .line 144
    invoke-interface {p1, v0}, Lng/x;->H(Ljava/lang/Object;)Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 145
    .line 146
    .line 147
    invoke-interface {v1, v5}, Lwg/a;->c(Ljava/lang/Object;)V

    .line 148
    .line 149
    .line 150
    return-object v0

    .line 151
    :goto_4
    invoke-interface {v1, v5}, Lwg/a;->c(Ljava/lang/Object;)V

    .line 152
    .line 153
    .line 154
    throw p1
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
    .line 197
.end method
