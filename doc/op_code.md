# 助记符定义（草案）

PrgmOne 使用类似汇编的语法，因而沿用了“助记符”的称呼。

| 表格测试	| 栏目1		| 栏目2		|
| ---------	| ---------	| ---------	|
| 测试		| 测试		| 测试		|

## 一般操作

一般操作指对寄存器、内存的存取操作。

* mov src, dest

## 数学操作

大多数数学操作的对象都是 a.

* add a, b
* sub a, b 
* mul a, b 
* imul a, b
* div a, b
* idiv a, b
* flr a
* rand a
* and a, b
* or a, b
* not a
* xor a, b

## 堆栈操作

* push a
* pop a
* pushad
* popad

## 外设操作

## 中断系统

* sti : 允许中断
* cli : 禁止中断
* sir type, lbl : 设置中断
* cir type : 清除中断

