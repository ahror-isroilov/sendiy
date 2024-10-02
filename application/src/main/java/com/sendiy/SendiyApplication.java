package com.sendiy;

import com.sendiy.user.UserDomain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@SpringBootApplication
public class SendiyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SendiyApplication.class, args);
    }

    @GetMapping("/datetime")
    private String currentDateTime() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>sendiy</title>
                    <link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
                    <style>
                        /* Reset default styles */
                        body, html {
                            margin: 0;
                            padding: 0;
                            width: 100%;
                            height: 100%;
                            overflow: hidden;
                            background: #000; /* Black background */
                        }
                
                        .poppins-r {
                            font-family: "Poppins", sans-serif;
                            font-weight: 400;
                            font-style: normal;
                        }
                
                        .background {
                            position: absolute;
                            top: 0;
                            left: 0;
                            width: 100%;
                            height: 100%;
                            overflow: hidden;
                        }
                
                        /* Background glow effect */
                        .background::before {
                            content: '';
                            position: absolute;
                            top: 50%;
                            left: 50%;
                            width: 200%;
                            height: 200%;
                            background: radial-gradient(circle, rgba(0, 0, 255, 0.5) 0%, rgba(128, 0, 128, 0) 70%);
                            filter: blur(120px);
                            animation: pulse 5s infinite ease-in-out;
                            transform: translate(-50%, -50%);
                        }
                
                        /* Particle styles */
                        .particle {
                            position: absolute;
                            border-radius: 45%;
                            filter: blur(15px);
                            opacity: 0.8;
                            animation: particles 15s infinite ease-in-out;
                            mix-blend-mode: screen; /* Makes the colors blend with the background */
                        }
                
                        /* Specific particle colors and sizes */
                        .particle-1 {
                            background: rgba(0, 0, 255, 0.6); /* Blue */
                            width: 180px;
                            height: 180px;
                            top: 10%;
                            left: 20%;
                            animation-delay: 30s;
                        }
                
                        .particle-2 {
                            background: rgba(128, 0, 128, 0.6); /* Purple */
                            width: 300px;
                            height: 300px;
                            top: 50%;
                            left: 40%;
                            animation-delay: 50s;
                        }
                
                        .particle-3 {
                            background: rgba(255, 105, 180, 0.6); /* Pink */
                            width: 250px;
                            height: 250px;
                            top: 70%;
                            left: 70%;
                            animation-delay: 40s;
                        }
                
                        /* Animations */
                        @keyframes particles {
                            0% {
                                transform: translateY(0) translateX(0);
                                opacity: 0.7;
                            }
                            50% {
                                transform: translateY(-300px) translateX(300px);
                                opacity: 1;
                            }
                            100% {
                                transform: translateY(-600px) translateX(-300px);
                                opacity: 0.7;
                            }
                        }
                
                        @keyframes pulse {
                            0%, 100% {
                                transform: translate(-50%, -50%) scale(1);
                            }
                            50% {
                                transform: translate(-50%, -50%) scale(1.2);
                            }
                        }
                
                        /* Centered text styles */
                        .centered-text {
                            position: absolute;
                            top: 50%;
                            left: 50%;
                            transform: translate(-50%, -50%);
                            font-family: 'Poppins', sans-serif;
                            font-weight: 500;
                            font-size: 2rem; /* Adjust font size as needed */
                            color: #b7eaee; /* Light teal color */
                            text-shadow: 0 0 10px rgba(0, 255, 255, 0.5), 0 0 20px rgba(0, 255, 255, 0.5); /* Neon glow effect */
                            text-align: center;
                        }
                
                    </style>
                </head>
                <body>
                <div class="background">
                    <div class="particle particle-1"></div>
                    <div class="particle particle-2"></div>
                    <div class="particle particle-3"></div>
                    <div class="centered-text">
                """ +
                DateTimeFormatter.ofPattern("MMMM dd, yyyy").format(LocalDateTime.now()) + """
                </div>
                </div>
                </body>
                </html>""";
    }

}
