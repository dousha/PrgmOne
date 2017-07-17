# 助记符定义（草案）

PrgmOne 使用类似汇编的语法，因而沿用了“助记符”的称呼。

为了降低编程门槛（以及还因为一些技术限制），取消了无符号数、简化了中断系统相关
的操作。

| 助记符			| 意义								| 注释			|
| ----------------- | --------------------------------- | ------------- |
| 普通部分			|									|				|
| nop				| 空闲一个周期						|				|
| mov src, dest		| 赋 dest 为 src 的值				|				|
| jmp lbl			| 跳转到一个标号					|				|
| call lbl			| 调用子程序						| 需要设置堆栈	|
| slp sec			| 暂停一段时间						|				|
| ret				| 从子程序中返回					| 需要设置堆栈	|
| 数学部分			| 									|				|
| add src, dest		| 向 src 加 dest					|				|
| sub src, dest		| 从 src 减去 dest					|				|
| mul src, dest		| 向 src 乘 dest					| 有符号操作	|
| div src, dest		| 从 src 除去 dest					| 有符号操作	|
| flr src			| 向下取整							|				|
| rand src			| 产生一个 [0, 1) 的随机数			|				|
| and src, dest		| 与操作							|				|
| or src, dest		| 或操作							|				|
| not src			| 非操作							|				|
| xor src, dest		| 异或操作							|				|
| shl dest, bits	| 左移								|				|
| shr dest, bits	| 右移								|				|
| rol dest, bits	| 循环左移							|				|
| ror dest, bits	| 循环右移							|				|
| 堆栈部分			| 									|				|
| sstk ptr			| 在 ptr 处设置堆栈，同 mov sp, ptr |				|
| push a			| 将 a 入栈							|				|
| pop a 			| 出栈到 a							|				|
| pushad			| 将所有寄存器内容与旗帜状态入栈	|				|
| popad				| 将旗帜状态与所有寄存器内容出栈	|				|
| 中断部分			|									|				|
| sti				| 允许中断，同手动设置 IF=1			|				|
| cli				| 禁止中断，同手动设置 IF=0			|				|
| sir type, lbl		| 设置中断 type 的服务程序为 lbl	|				|
| cir type			| 停止响应中断 type					|				|
| iret				| 从中断中返回						| 需要设置堆栈	|
| 外设部分			|									|				|
| speri side, type	| 初始化在 side 处的外设 type		|				|
| tx side, ptr		| 向 side 传输位于 ptr 的数据		|				|
| rx side, ptr		| 从 side 接受数据存储到 ptr		|				|
| txn side, ptr, n	| 向 side 传输位于 ptr 的 n 字节数据|				|
| rxn side, ptr, n	| 从 side 接受 n 字节数据存储至 ptr | 溢出部分截断	|
| cperi side		| 断开在 side 处的外设				|				|
| 互联网部分		|									|				|
| sinet ptr			| 在 ptr 处初始化网络结构体			|				|
| con ptr			| 使用 ptr 处的网络结构体创建套接字	|				|
| itx ptr, data		| 使用 ptr 处的网络结构体发送数据	|				|
| irx ptr, ptrdt	| 使用 ptr 处的网络结构体接收数据	|				|
| bye ptr			| 关闭 ptr 处的网络结构体的套接字	|				|
| cinet ptr			| 释放 ptr 处的网络结构体			|				|

关于寄存器、内存与立即数的记法如下：

| 类型		| 记法			| 示例						|
| --------- | ------------- | ------------------------- |
| 寄存器	| %name			| %r0, %r5, %flag			|
| 内存		| @mem			| @0xABADCAFE, @0x1234		|
| 立即数	| $number		| $42, $0xa, $0o6, $0b1001	|
| 方位		| &side			| &up, &north, &NE			|

其余非指令内容都当作标号解释。
