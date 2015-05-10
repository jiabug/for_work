#include <iostream>

using namespace std;
class exercise
{
public:
	exercise(arguments);
	~exercise();

	/* data */
};
void repalceSpaces(char[] str, int length)
{
	int spacecount = 0, newLength;
	for (int i = 0; i < length; ++i)
	{
		if (str[i] == ' ')
		{
			spacecount++;
		}
	}

	newLength = length + spacecount * 2;
	str[newLength] = '\0';

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

int main()
{
	char str[] = "jia kang ze";
	//int length = str.length();

	//repalceSpaces(str, length);
	cout<<str<<endl;
}