.class public Lcom/amazon/a/b/f;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/a/b/f$b;,
        Lcom/amazon/a/b/f$a;,
        Lcom/amazon/a/b/f$c;
    }
.end annotation


# instance fields
.field private final a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Class<",
            "+",
            "Lcom/amazon/a/a/d/b;",
            ">;",
            "Lcom/amazon/a/b/f$c<",
            "+",
            "Lcom/amazon/a/a/d/b;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 3

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/HashMap;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lcom/amazon/a/b/f;->a:Ljava/util/Map;

    .line 10
    .line 11
    const-string v0, "Amazon"

    .line 12
    .line 13
    sget-object v1, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    .line 14
    .line 15
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 16
    .line 17
    .line 18
    move-result v0

    .line 19
    const-class v1, Lcom/amazon/a/a/n/a/a/c;

    .line 20
    .line 21
    if-eqz v0, :cond_0

    .line 22
    .line 23
    sget-object v0, Lcom/amazon/a/b/e;->b:Lcom/amazon/a/a/i/c;

    .line 24
    .line 25
    invoke-direct {p0, v1, v0}, Lcom/amazon/a/b/f;->a(Ljava/lang/Class;Lcom/amazon/a/a/i/c;)V

    .line 26
    .line 27
    .line 28
    goto :goto_0

    .line 29
    :cond_0
    sget-object v0, Lcom/amazon/a/b/e;->a:Lcom/amazon/a/a/i/c;

    .line 30
    .line 31
    invoke-direct {p0, v1, v0}, Lcom/amazon/a/b/f;->a(Ljava/lang/Class;Lcom/amazon/a/a/i/c;)V

    .line 32
    .line 33
    .line 34
    :goto_0
    sget-object v0, Lcom/amazon/a/b/e;->b:Lcom/amazon/a/a/i/c;

    .line 35
    .line 36
    const-class v1, Lcom/amazon/a/a/n/a/a/b;

    .line 37
    .line 38
    invoke-direct {p0, v1, v0}, Lcom/amazon/a/b/f;->a(Ljava/lang/Class;Lcom/amazon/a/a/i/c;)V

    .line 39
    .line 40
    .line 41
    const-class v1, Lcom/amazon/a/a/n/a/a/d;

    .line 42
    .line 43
    invoke-direct {p0, v1, v0}, Lcom/amazon/a/b/f;->a(Ljava/lang/Class;Lcom/amazon/a/a/i/c;)V

    .line 44
    .line 45
    .line 46
    const-class v0, Lcom/amazon/a/a/n/a/a/a;

    .line 47
    .line 48
    sget-object v1, Lcom/amazon/a/b/e;->c:Lcom/amazon/a/a/i/c;

    .line 49
    .line 50
    invoke-direct {p0, v0, v1}, Lcom/amazon/a/b/f;->a(Ljava/lang/Class;Lcom/amazon/a/a/i/c;)V

    .line 51
    .line 52
    .line 53
    new-instance v0, Lcom/amazon/a/b/f$a;

    .line 54
    .line 55
    const/4 v1, 0x0

    .line 56
    invoke-direct {v0, v1}, Lcom/amazon/a/b/f$a;-><init>(Lcom/amazon/a/b/f$1;)V

    .line 57
    .line 58
    .line 59
    const-class v2, Lcom/amazon/a/a/n/a/a/f;

    .line 60
    .line 61
    invoke-direct {p0, v2, v0}, Lcom/amazon/a/b/f;->a(Ljava/lang/Class;Lcom/amazon/a/b/f$c;)V

    .line 62
    .line 63
    .line 64
    sget-object v0, Lcom/amazon/a/b/e;->e:Lcom/amazon/a/a/i/c;

    .line 65
    .line 66
    const-class v2, Lcom/amazon/a/a/n/a/a/g;

    .line 67
    .line 68
    invoke-direct {p0, v2, v0}, Lcom/amazon/a/b/f;->a(Ljava/lang/Class;Lcom/amazon/a/a/i/c;)V

    .line 69
    .line 70
    .line 71
    const-class v2, Lcom/amazon/a/a/n/a/a/h;

    .line 72
    .line 73
    invoke-direct {p0, v2, v0}, Lcom/amazon/a/b/f;->a(Ljava/lang/Class;Lcom/amazon/a/a/i/c;)V

    .line 74
    .line 75
    .line 76
    new-instance v2, Lcom/amazon/a/b/f$b;

    .line 77
    .line 78
    invoke-direct {v2, v1}, Lcom/amazon/a/b/f$b;-><init>(Lcom/amazon/a/b/f$1;)V

    .line 79
    .line 80
    .line 81
    const-class v1, Lcom/amazon/a/b/a/a;

    .line 82
    .line 83
    invoke-direct {p0, v1, v2}, Lcom/amazon/a/b/f;->a(Ljava/lang/Class;Lcom/amazon/a/b/f$c;)V

    .line 84
    .line 85
    .line 86
    const-class v1, Lcom/amazon/a/a/o/b/a/a;

    .line 87
    .line 88
    sget-object v2, Lcom/amazon/a/b/e;->g:Lcom/amazon/a/a/i/c;

    .line 89
    .line 90
    invoke-direct {p0, v1, v2}, Lcom/amazon/a/b/f;->a(Ljava/lang/Class;Lcom/amazon/a/a/i/c;)V

    .line 91
    .line 92
    .line 93
    const-class v1, Lcom/amazon/a/a/o/b/a/b;

    .line 94
    .line 95
    invoke-direct {p0, v1, v0}, Lcom/amazon/a/b/f;->a(Ljava/lang/Class;Lcom/amazon/a/a/i/c;)V

    .line 96
    .line 97
    .line 98
    const-class v1, Lcom/amazon/a/a/o/b/a/c;

    .line 99
    .line 100
    invoke-direct {p0, v1, v0}, Lcom/amazon/a/b/f;->a(Ljava/lang/Class;Lcom/amazon/a/a/i/c;)V

    .line 101
    .line 102
    .line 103
    return-void
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

.method private a(Ljava/lang/Class;Lcom/amazon/a/a/i/c;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "+",
            "Lcom/amazon/a/a/d/b;",
            ">;",
            "Lcom/amazon/a/a/i/c;",
            ")V"
        }
    .end annotation

    .line 1
    new-instance v0, Lcom/amazon/a/b/f$1;

    invoke-direct {v0, p0, p2}, Lcom/amazon/a/b/f$1;-><init>(Lcom/amazon/a/b/f;Lcom/amazon/a/a/i/c;)V

    .line 2
    invoke-direct {p0, p1, v0}, Lcom/amazon/a/b/f;->a(Ljava/lang/Class;Lcom/amazon/a/b/f$c;)V

    return-void
.end method

.method private a(Ljava/lang/Class;Lcom/amazon/a/b/f$c;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "+",
            "Lcom/amazon/a/a/d/b;",
            ">;",
            "Lcom/amazon/a/b/f$c<",
            "+",
            "Lcom/amazon/a/a/d/b;",
            ">;)V"
        }
    .end annotation

    .line 3
    iget-object v0, p0, Lcom/amazon/a/b/f;->a:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "mapping exists for type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/a/a/o/a/a;->b(ZLjava/lang/String;)V

    .line 4
    iget-object v0, p0, Lcom/amazon/a/b/f;->a:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public a(Lcom/amazon/a/a/d/b;)Lcom/amazon/a/a/i/c;
    .locals 2

    .line 5
    iget-object v0, p0, Lcom/amazon/a/b/f;->a:Ljava/util/Map;

    .line 6
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/a/b/f$c;

    if-nez v0, :cond_0

    const/4 p1, 0x0

    return-object p1

    .line 7
    :cond_0
    invoke-interface {v0, p1}, Lcom/amazon/a/b/f$c;->a(Lcom/amazon/a/a/d/b;)Lcom/amazon/a/a/i/c;

    move-result-object p1

    return-object p1
.end method
