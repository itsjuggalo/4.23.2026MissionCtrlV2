.class public Lcom/google/firebase/firestore/FirestoreRegistrar;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcom/google/firebase/components/ComponentRegistrar;


# annotations
.annotation build Landroidx/annotation/Keep;
.end annotation


# static fields
.field private static final LIBRARY_NAME:Ljava/lang/String; = "fire-fst"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    return-void
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
.end method

.method public static synthetic a(Lo7/d;)Lcom/google/firebase/firestore/h;
    .locals 9

    .line 1
    new-instance v0, Lcom/google/firebase/firestore/h;

    .line 2
    .line 3
    const-class v1, Landroid/content/Context;

    .line 4
    .line 5
    invoke-interface {p0, v1}, Lo7/d;->get(Ljava/lang/Class;)Ljava/lang/Object;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    check-cast v1, Landroid/content/Context;

    .line 10
    .line 11
    const-class v2, La7/g;

    .line 12
    .line 13
    invoke-interface {p0, v2}, Lo7/d;->get(Ljava/lang/Class;)Ljava/lang/Object;

    .line 14
    .line 15
    .line 16
    move-result-object v2

    .line 17
    check-cast v2, La7/g;

    .line 18
    .line 19
    const-class v3, Ln7/b;

    .line 20
    .line 21
    invoke-interface {p0, v3}, Lo7/d;->h(Ljava/lang/Class;)Lfa/a;

    .line 22
    .line 23
    .line 24
    move-result-object v3

    .line 25
    const-class v4, Lj7/b;

    .line 26
    .line 27
    invoke-interface {p0, v4}, Lo7/d;->h(Ljava/lang/Class;)Lfa/a;

    .line 28
    .line 29
    .line 30
    move-result-object v4

    .line 31
    new-instance v5, Lm9/s;

    .line 32
    .line 33
    const-class v6, Loa/i;

    .line 34
    .line 35
    invoke-interface {p0, v6}, Lo7/d;->b(Ljava/lang/Class;)Lfa/b;

    .line 36
    .line 37
    .line 38
    move-result-object v6

    .line 39
    const-class v7, Lo9/j;

    .line 40
    .line 41
    invoke-interface {p0, v7}, Lo7/d;->b(Ljava/lang/Class;)Lfa/b;

    .line 42
    .line 43
    .line 44
    move-result-object v7

    .line 45
    const-class v8, La7/p;

    .line 46
    .line 47
    invoke-interface {p0, v8}, Lo7/d;->get(Ljava/lang/Class;)Ljava/lang/Object;

    .line 48
    .line 49
    .line 50
    move-result-object p0

    .line 51
    check-cast p0, La7/p;

    .line 52
    .line 53
    invoke-direct {v5, v6, v7, p0}, Lm9/s;-><init>(Lfa/b;Lfa/b;La7/p;)V

    .line 54
    .line 55
    .line 56
    invoke-direct/range {v0 .. v5}, Lcom/google/firebase/firestore/h;-><init>(Landroid/content/Context;La7/g;Lfa/a;Lfa/a;Lm9/i0;)V

    .line 57
    .line 58
    .line 59
    return-object v0
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


# virtual methods
.method public getComponents()Ljava/util/List;
    .locals 3
    .annotation build Landroidx/annotation/Keep;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lo7/c;",
            ">;"
        }
    .end annotation

    .line 1
    const-class v0, Lcom/google/firebase/firestore/h;

    .line 2
    .line 3
    invoke-static {v0}, Lo7/c;->c(Ljava/lang/Class;)Lo7/c$b;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const-string v1, "fire-fst"

    .line 8
    .line 9
    invoke-virtual {v0, v1}, Lo7/c$b;->h(Ljava/lang/String;)Lo7/c$b;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    const-class v2, La7/g;

    .line 14
    .line 15
    invoke-static {v2}, Lo7/q;->k(Ljava/lang/Class;)Lo7/q;

    .line 16
    .line 17
    .line 18
    move-result-object v2

    .line 19
    invoke-virtual {v0, v2}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    const-class v2, Landroid/content/Context;

    .line 24
    .line 25
    invoke-static {v2}, Lo7/q;->k(Ljava/lang/Class;)Lo7/q;

    .line 26
    .line 27
    .line 28
    move-result-object v2

    .line 29
    invoke-virtual {v0, v2}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 30
    .line 31
    .line 32
    move-result-object v0

    .line 33
    const-class v2, Lo9/j;

    .line 34
    .line 35
    invoke-static {v2}, Lo7/q;->i(Ljava/lang/Class;)Lo7/q;

    .line 36
    .line 37
    .line 38
    move-result-object v2

    .line 39
    invoke-virtual {v0, v2}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 40
    .line 41
    .line 42
    move-result-object v0

    .line 43
    const-class v2, Loa/i;

    .line 44
    .line 45
    invoke-static {v2}, Lo7/q;->i(Ljava/lang/Class;)Lo7/q;

    .line 46
    .line 47
    .line 48
    move-result-object v2

    .line 49
    invoke-virtual {v0, v2}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 50
    .line 51
    .line 52
    move-result-object v0

    .line 53
    const-class v2, Ln7/b;

    .line 54
    .line 55
    invoke-static {v2}, Lo7/q;->a(Ljava/lang/Class;)Lo7/q;

    .line 56
    .line 57
    .line 58
    move-result-object v2

    .line 59
    invoke-virtual {v0, v2}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 60
    .line 61
    .line 62
    move-result-object v0

    .line 63
    const-class v2, Lj7/b;

    .line 64
    .line 65
    invoke-static {v2}, Lo7/q;->a(Ljava/lang/Class;)Lo7/q;

    .line 66
    .line 67
    .line 68
    move-result-object v2

    .line 69
    invoke-virtual {v0, v2}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 70
    .line 71
    .line 72
    move-result-object v0

    .line 73
    const-class v2, La7/p;

    .line 74
    .line 75
    invoke-static {v2}, Lo7/q;->h(Ljava/lang/Class;)Lo7/q;

    .line 76
    .line 77
    .line 78
    move-result-object v2

    .line 79
    invoke-virtual {v0, v2}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 80
    .line 81
    .line 82
    move-result-object v0

    .line 83
    new-instance v2, Ld9/p0;

    .line 84
    .line 85
    invoke-direct {v2}, Ld9/p0;-><init>()V

    .line 86
    .line 87
    .line 88
    invoke-virtual {v0, v2}, Lo7/c$b;->f(Lo7/g;)Lo7/c$b;

    .line 89
    .line 90
    .line 91
    move-result-object v0

    .line 92
    invoke-virtual {v0}, Lo7/c$b;->d()Lo7/c;

    .line 93
    .line 94
    .line 95
    move-result-object v0

    .line 96
    const-string v2, "26.0.2"

    .line 97
    .line 98
    invoke-static {v1, v2}, Loa/h;->b(Ljava/lang/String;Ljava/lang/String;)Lo7/c;

    .line 99
    .line 100
    .line 101
    move-result-object v1

    .line 102
    filled-new-array {v0, v1}, [Lo7/c;

    .line 103
    .line 104
    .line 105
    move-result-object v0

    .line 106
    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    .line 107
    .line 108
    .line 109
    move-result-object v0

    .line 110
    return-object v0
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
