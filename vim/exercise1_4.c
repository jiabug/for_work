#include <stdio.h>
//#include <string.h>

void repalceSpaces(char* str, int length)
{
	int spacecount = 0, newlength;
	for (int i = 0; i < length; i++)
	{
		if (str[i] == ' ')
		{
			spacecount++;
		}
	}

	newlength = length + spacecount * 2;
	str[newlength] = '\0';

	for (int i = length - 1; i >= 0; i--)
	{
		if (str[i] == ' ')
		{
			str[newlength-1] = '0';
			str[newlength-2] = '2';
			str[newlength-3] = '%';
			newlength -= 3;
		}
		else
		{
			str[newlength - 1] = str[i];
			newlength = newlength - 1;
		}
	}
}

int main(int argc, char const *argv[])
{
	char str[] = "jia kang ze";//在这里我们不能用char*  这样默认为const   就不能改变了  这里的＝不是赋值运算
	repalceSpaces(str, 20);//函数参数里面的char * str 这里仅仅代表str的首地址   当把首地址传到函数中，就能当作数组来操作了
    printf("%s\n",str);
	return 0;
}