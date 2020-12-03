Scenario: when a bot is inited with a bot config

Given a bot config /config.yaml
When the bot authenticates
Then a bot session is created