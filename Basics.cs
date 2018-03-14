using System;

namespace Basics
{
    class Program
    {
        static void Main(string[] args)
        {
            const byte sample1 = 0x3A;
            sbyte sample2 = 58;
            int heartRate = 85;
            double deposits = 135002796;
            const float acceleration = 9.800f;
            float mass = 14.6f;
            double distance = 129.763001;
            bool lost = true;
            bool expensive = true;
            int choice = 2;
            const char integral = '\u{ 222B}';
            const string greeting = "Hello";
            string name = "Karen";

            if (sample1 == sample2) {
                Console.WriteLine("The Samples are Equal");
            } else {
                Console.WriteLine("The Samples are not Equal");
            }

            if (heartRate >= 40 && heartRate <= 80) {
                Console.WriteLine("Heart Rate is Normal");
            } else {
                Console.WriteLine("Heart Rate is not Normal");
            }

            if (deposits >= 100000000) {
                Console.WriteLine("You are exceedingly wealthy");
            } else {
                Console.WriteLine("Sorry you are so poor");
            }

            double force = mass * acceleration;
            Console.WriteLine("force = " + force);

            Console.WriteLine(distance + " is in the distance");

            if (lost == true && expensive == true) {
                Console.WriteLine("I am really sorry! I will get the manager.");
            } else if (lost == true && expensive == false) {
                Console.WriteLine("Here is coupon for 10% off.");
            }

            switch (choice)
            {
                case 1:
                    Console.WriteLine("You chose 1");
                    break;
                case 2:
                    Console.WriteLine("You chose 2");
                    break;
                case 3:
                    Console.WriteLine("You chose 3");
                    break;
                default:
                    Console.WriteLine("Unknown Choice");
                    break;
            }

            for (int i = 5; i <= 10; i++)
            {
                Console.WriteLine(i);
            }

            int age = 0;
            while (age < 6)
            {
                Console.WriteLine("age = " + age);
                age++;
            }

            Console.WriteLine(greeting + " " + name);
        }
    }
}
