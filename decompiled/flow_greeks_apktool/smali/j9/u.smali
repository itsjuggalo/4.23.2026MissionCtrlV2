.class public abstract Lj9/u;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# direct methods
.method public static a(Lbb/d0;)Lcom/google/protobuf/s1;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lbb/d0;->s0()Lbb/u;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    const-string v0, "__local_write_time__"

    .line 6
    .line 7
    invoke-virtual {p0, v0}, Lbb/u;->f0(Ljava/lang/String;)Lbb/d0;

    .line 8
    .line 9
    .line 10
    move-result-object p0

    .line 11
    invoke-virtual {p0}, Lbb/d0;->v0()Lcom/google/protobuf/s1;

    .line 12
    .line 13
    .line 14
    move-result-object p0

    .line 15
    return-object p0
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

.method public static b(Lbb/d0;)Lbb/d0;
    .locals 2

    .line 1
    invoke-virtual {p0}, Lbb/d0;->s0()Lbb/u;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    const-string v0, "__previous_value__"

    .line 6
    .line 7
    const/4 v1, 0x0

    .line 8
    invoke-virtual {p0, v0, v1}, Lbb/u;->e0(Ljava/lang/String;Lbb/d0;)Lbb/d0;

    .line 9
    .line 10
    .line 11
    move-result-object p0

    .line 12
    invoke-static {p0}, Lj9/u;->c(Lbb/d0;)Z

    .line 13
    .line 14
    .line 15
    move-result v0

    .line 16
    if-eqz v0, :cond_0

    .line 17
    .line 18
    invoke-static {p0}, Lj9/u;->b(Lbb/d0;)Lbb/d0;

    .line 19
    .line 20
    .line 21
    move-result-object p0

    .line 22
    :cond_0
    return-object p0
    .line 23
    .line 24
.end method

.method public static c(Lbb/d0;)Z
    .locals 2

    .line 1
    const/4 v0, 0x0

    .line 2
    if-nez p0, :cond_0

    .line 3
    .line 4
    goto :goto_0

    .line 5
    :cond_0
    invoke-virtual {p0}, Lbb/d0;->s0()Lbb/u;

    .line 6
    .line 7
    .line 8
    move-result-object p0

    .line 9
    const-string v1, "__type__"

    .line 10
    .line 11
    invoke-virtual {p0, v1, v0}, Lbb/u;->e0(Ljava/lang/String;Lbb/d0;)Lbb/d0;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    :goto_0
    if-eqz v0, :cond_1

    .line 16
    .line 17
    const-string p0, "server_timestamp"

    .line 18
    .line 19
    invoke-virtual {v0}, Lbb/d0;->u0()Ljava/lang/String;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 24
    .line 25
    .line 26
    move-result p0

    .line 27
    if-eqz p0, :cond_1

    .line 28
    .line 29
    const/4 p0, 0x1

    .line 30
    return p0

    .line 31
    :cond_1
    const/4 p0, 0x0

    .line 32
    return p0
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
.end method

.method public static d(La7/s;Lbb/d0;)Lbb/d0;
    .locals 5

    .line 1
    invoke-static {}, Lbb/d0;->y0()Lbb/d0$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const-string v1, "server_timestamp"

    .line 6
    .line 7
    invoke-virtual {v0, v1}, Lbb/d0$b;->J(Ljava/lang/String;)Lbb/d0$b;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    invoke-virtual {v0}, Lcom/google/protobuf/y$a;->n()Lcom/google/protobuf/y;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    check-cast v0, Lbb/d0;

    .line 16
    .line 17
    invoke-static {}, Lbb/d0;->y0()Lbb/d0$b;

    .line 18
    .line 19
    .line 20
    move-result-object v1

    .line 21
    invoke-static {}, Lcom/google/protobuf/s1;->f0()Lcom/google/protobuf/s1$b;

    .line 22
    .line 23
    .line 24
    move-result-object v2

    .line 25
    invoke-virtual {p0}, La7/s;->h()J

    .line 26
    .line 27
    .line 28
    move-result-wide v3

    .line 29
    invoke-virtual {v2, v3, v4}, Lcom/google/protobuf/s1$b;->y(J)Lcom/google/protobuf/s1$b;

    .line 30
    .line 31
    .line 32
    move-result-object v2

    .line 33
    invoke-virtual {p0}, La7/s;->b()I

    .line 34
    .line 35
    .line 36
    move-result p0

    .line 37
    invoke-virtual {v2, p0}, Lcom/google/protobuf/s1$b;->x(I)Lcom/google/protobuf/s1$b;

    .line 38
    .line 39
    .line 40
    move-result-object p0

    .line 41
    invoke-virtual {v1, p0}, Lbb/d0$b;->K(Lcom/google/protobuf/s1$b;)Lbb/d0$b;

    .line 42
    .line 43
    .line 44
    move-result-object p0

    .line 45
    invoke-virtual {p0}, Lcom/google/protobuf/y$a;->n()Lcom/google/protobuf/y;

    .line 46
    .line 47
    .line 48
    move-result-object p0

    .line 49
    check-cast p0, Lbb/d0;

    .line 50
    .line 51
    invoke-static {}, Lbb/u;->j0()Lbb/u$b;

    .line 52
    .line 53
    .line 54
    move-result-object v1

    .line 55
    const-string v2, "__type__"

    .line 56
    .line 57
    invoke-virtual {v1, v2, v0}, Lbb/u$b;->z(Ljava/lang/String;Lbb/d0;)Lbb/u$b;

    .line 58
    .line 59
    .line 60
    move-result-object v0

    .line 61
    const-string v1, "__local_write_time__"

    .line 62
    .line 63
    invoke-virtual {v0, v1, p0}, Lbb/u$b;->z(Ljava/lang/String;Lbb/d0;)Lbb/u$b;

    .line 64
    .line 65
    .line 66
    move-result-object p0

    .line 67
    invoke-static {p1}, Lj9/u;->c(Lbb/d0;)Z

    .line 68
    .line 69
    .line 70
    move-result v0

    .line 71
    if-eqz v0, :cond_0

    .line 72
    .line 73
    invoke-static {p1}, Lj9/u;->b(Lbb/d0;)Lbb/d0;

    .line 74
    .line 75
    .line 76
    move-result-object p1

    .line 77
    :cond_0
    if-eqz p1, :cond_1

    .line 78
    .line 79
    const-string v0, "__previous_value__"

    .line 80
    .line 81
    invoke-virtual {p0, v0, p1}, Lbb/u$b;->z(Ljava/lang/String;Lbb/d0;)Lbb/u$b;

    .line 82
    .line 83
    .line 84
    :cond_1
    invoke-static {}, Lbb/d0;->y0()Lbb/d0$b;

    .line 85
    .line 86
    .line 87
    move-result-object p1

    .line 88
    invoke-virtual {p1, p0}, Lbb/d0$b;->F(Lbb/u$b;)Lbb/d0$b;

    .line 89
    .line 90
    .line 91
    move-result-object p0

    .line 92
    invoke-virtual {p0}, Lcom/google/protobuf/y$a;->n()Lcom/google/protobuf/y;

    .line 93
    .line 94
    .line 95
    move-result-object p0

    .line 96
    check-cast p0, Lbb/d0;

    .line 97
    .line 98
    return-object p0
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
